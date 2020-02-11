import { Component, Vue, Inject } from 'vue-property-decorator';

import { INotificacion } from '@/shared/model/notificacion.model';
import NotificacionService from './notificacion.service';

@Component
export default class NotificacionDetails extends Vue {
  @Inject('notificacionService') private notificacionService: () => NotificacionService;
  public notificacion: INotificacion = {};

  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (to.params.notificacionId) {
        vm.retrieveNotificacion(to.params.notificacionId);
      }
    });
  }

  public retrieveNotificacion(notificacionId) {
    this.notificacionService()
      .find(notificacionId)
      .then(res => {
        this.notificacion = res;
      });
  }

  public previousState() {
    this.$router.go(-1);
  }
}
