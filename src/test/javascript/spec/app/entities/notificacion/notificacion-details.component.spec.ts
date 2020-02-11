/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import * as config from '@/shared/config/config';
import NotificacionDetailComponent from '@/entities/notificacion/notificacion-details.vue';
import NotificacionClass from '@/entities/notificacion/notificacion-details.component';
import NotificacionService from '@/entities/notificacion/notificacion.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('router-link', {});

describe('Component Tests', () => {
  describe('Notificacion Management Detail Component', () => {
    let wrapper: Wrapper<NotificacionClass>;
    let comp: NotificacionClass;
    let notificacionServiceStub: SinonStubbedInstance<NotificacionService>;

    beforeEach(() => {
      notificacionServiceStub = sinon.createStubInstance<NotificacionService>(NotificacionService);

      wrapper = shallowMount<NotificacionClass>(NotificacionDetailComponent, {
        store,
        i18n,
        localVue,
        provide: { notificacionService: () => notificacionServiceStub }
      });
      comp = wrapper.vm;
    });

    describe('OnInit', () => {
      it('Should call load all on init', async () => {
        // GIVEN
        const foundNotificacion = { id: '123' };
        notificacionServiceStub.find.resolves(foundNotificacion);

        // WHEN
        comp.retrieveNotificacion('123');
        await comp.$nextTick();

        // THEN
        expect(comp.notificacion).toBe(foundNotificacion);
      });
    });
  });
});
