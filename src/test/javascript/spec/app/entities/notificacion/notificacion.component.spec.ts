/* tslint:disable max-line-length */
import { shallowMount, createLocalVue, Wrapper } from '@vue/test-utils';
import sinon, { SinonStubbedInstance } from 'sinon';

import AlertService from '@/shared/alert/alert.service';
import * as config from '@/shared/config/config';
import NotificacionComponent from '@/entities/notificacion/notificacion.vue';
import NotificacionClass from '@/entities/notificacion/notificacion.component';
import NotificacionService from '@/entities/notificacion/notificacion.service';

const localVue = createLocalVue();

config.initVueApp(localVue);
const i18n = config.initI18N(localVue);
const store = config.initVueXStore(localVue);
localVue.component('font-awesome-icon', {});
localVue.component('b-alert', {});
localVue.component('b-badge', {});
localVue.directive('b-modal', {});
localVue.component('b-button', {});
localVue.component('router-link', {});

const bModalStub = {
  render: () => {},
  methods: {
    hide: () => {}
  }
};

describe('Component Tests', () => {
  describe('Notificacion Management Component', () => {
    let wrapper: Wrapper<NotificacionClass>;
    let comp: NotificacionClass;
    let notificacionServiceStub: SinonStubbedInstance<NotificacionService>;

    beforeEach(() => {
      notificacionServiceStub = sinon.createStubInstance<NotificacionService>(NotificacionService);
      notificacionServiceStub.retrieve.resolves({ headers: {} });

      wrapper = shallowMount<NotificacionClass>(NotificacionComponent, {
        store,
        i18n,
        localVue,
        stubs: { jhiItemCount: true, bPagination: true, bModal: bModalStub as any },
        provide: {
          alertService: () => new AlertService(store),
          notificacionService: () => notificacionServiceStub
        }
      });
      comp = wrapper.vm;
    });

    it('should be a Vue instance', () => {
      expect(wrapper.isVueInstance()).toBeTruthy();
    });

    it('Should call load all on init', async () => {
      // GIVEN
      notificacionServiceStub.retrieve.resolves({ headers: {}, data: [{ id: '123' }] });

      // WHEN
      comp.retrieveAllNotificacions();
      await comp.$nextTick();

      // THEN
      expect(notificacionServiceStub.retrieve.called).toBeTruthy();
      expect(comp.notificacions[0]).toEqual(jasmine.objectContaining({ id: '123' }));
    });

    it('should load a page', async () => {
      // GIVEN
      notificacionServiceStub.retrieve.resolves({ headers: {}, data: [{ id: '123' }] });
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();

      // THEN
      expect(notificacionServiceStub.retrieve.called).toBeTruthy();
      expect(comp.notificacions[0]).toEqual(jasmine.objectContaining({ id: '123' }));
    });

    it('should not load a page if the page is the same as the previous page', () => {
      // GIVEN
      notificacionServiceStub.retrieve.reset();
      comp.previousPage = 1;

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(notificacionServiceStub.retrieve.called).toBeFalsy();
    });

    it('should re-initialize the page', async () => {
      // GIVEN
      notificacionServiceStub.retrieve.reset();
      notificacionServiceStub.retrieve.resolves({ headers: {}, data: [{ id: '123' }] });

      // WHEN
      comp.loadPage(2);
      await comp.$nextTick();
      comp.clear();
      await comp.$nextTick();

      // THEN
      expect(notificacionServiceStub.retrieve.callCount).toEqual(3);
      expect(comp.page).toEqual(1);
      expect(comp.notificacions[0]).toEqual(jasmine.objectContaining({ id: '123' }));
    });

    it('should calculate the sort attribute for an id', () => {
      // WHEN
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['id,desc']);
    });

    it('should calculate the sort attribute for a non-id attribute', () => {
      // GIVEN
      comp.propOrder = 'name';

      // WHEN
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['name,desc', 'id']);
    });
    it('Should call delete service on confirmDelete', async () => {
      // GIVEN
      notificacionServiceStub.delete.resolves({});

      // WHEN
      comp.prepareRemove({ id: '123' });
      comp.removeNotificacion();
      await comp.$nextTick();

      // THEN
      expect(notificacionServiceStub.delete.called).toBeTruthy();
      expect(notificacionServiceStub.retrieve.callCount).toEqual(2);
    });
  });
});
