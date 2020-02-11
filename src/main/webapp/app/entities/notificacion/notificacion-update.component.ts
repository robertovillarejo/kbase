import { Component, Vue, Inject } from 'vue-property-decorator';

import { numeric, required, minLength, maxLength } from 'vuelidate/lib/validators';
import format from 'date-fns/format';
import parse from 'date-fns/parse';
import parseISO from 'date-fns/parseISO';
import { DATE_TIME_LONG_FORMAT } from '@/shared/date/filters';

import AlertService from '@/shared/alert/alert.service';
import { INotificacion, Notificacion } from '@/shared/model/notificacion.model';
import NotificacionService from './notificacion.service';

const validations: any = {
  notificacion: {
    destinatarios: {},
    remitente: {},
    fechaEnvio: {},
    asunto: {},
    mensaje: {},
    cc: {},
    cco: {}
  }
};

@Component({
  validations
})
export default class NotificacionUpdate extends Vue {
  @Inject('alertService') private alertService: () => AlertService;
  @Inject('notificacionService') private notificacionService: () => NotificacionService;
  public notificacion: INotificacion = new Notificacion();
  public isSaving = false;

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.notificacionId) {
        vm.retrieveNotificacion(to.params.notificacionId);
      }
    });
  }

  public save(): void {
    this.isSaving = true;
    if (this.notificacion.id) {
      this.notificacionService()
        .update(this.notificacion)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('kbaseApp.notificacion.updated', { param: param.id });
          this.alertService().showAlert(message, 'info');
        });
    } else {
      this.notificacionService()
        .create(this.notificacion)
        .then(param => {
          this.isSaving = false;
          this.$router.go(-1);
          const message = this.$t('kbaseApp.notificacion.created', { param: param.id });
          this.alertService().showAlert(message, 'success');
        });
    }
  }

  public convertDateTimeFromServer(date: Date): string {
    if (date) {
      return format(date, DATE_TIME_LONG_FORMAT);
    }
    return null;
  }

  public updateInstantField(field, event) {
    if (event.target.value) {
      this.notificacion[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.notificacion[field] = null;
    }
  }

  public updateZonedDateTimeField(field, event) {
    if (event.target.value) {
      this.notificacion[field] = parse(event.target.value, DATE_TIME_LONG_FORMAT, new Date());
    } else {
      this.notificacion[field] = null;
    }
  }

  public retrieveNotificacion(notificacionId): void {
    this.notificacionService()
      .find(notificacionId)
      .then(res => {
        res.fechaEnvio = new Date(res.fechaEnvio);
        this.notificacion = res;
      });
  }

  public previousState(): void {
    this.$router.go(-1);
  }

  public initRelationships(): void {}
}
