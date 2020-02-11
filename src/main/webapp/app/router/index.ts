import Vue from 'vue';
import Component from 'vue-class-component';
Component.registerHooks([
  'beforeRouteEnter',
  'beforeRouteLeave',
  'beforeRouteUpdate' // for vue-router 2.2+
]);
import Router from 'vue-router';
const Home = () => import('../core/home/home.vue');
const Error = () => import('../core/error/error.vue');
const Register = () => import('../account/register/register.vue');
const Activate = () => import('../account/activate/activate.vue');
const ResetPasswordInit = () => import('../account/reset-password/init/reset-password-init.vue');
const ResetPasswordFinish = () => import('../account/reset-password/finish/reset-password-finish.vue');
const ChangePassword = () => import('../account/change-password/change-password.vue');
const Settings = () => import('../account/settings/settings.vue');
const JhiUserManagementComponent = () => import('../admin/user-management/user-management.vue');
const JhiUserManagementViewComponent = () => import('../admin/user-management/user-management-view.vue');
const JhiUserManagementEditComponent = () => import('../admin/user-management/user-management-edit.vue');
const JhiConfigurationComponent = () => import('../admin/configuration/configuration.vue');
const JhiDocsComponent = () => import('../admin/docs/docs.vue');
const JhiHealthComponent = () => import('../admin/health/health.vue');
const JhiLogsComponent = () => import('../admin/logs/logs.vue');
const JhiAuditsComponent = () => import('../admin/audits/audits.vue');
const JhiMetricsComponent = () => import('../admin/metrics/metrics.vue');
/* tslint:disable */
// prettier-ignore
const MensajeError = () => import('../entities/mensaje-error/mensaje-error.vue');
// prettier-ignore
const MensajeErrorUpdate = () => import('../entities/mensaje-error/mensaje-error-update.vue');
// prettier-ignore
const MensajeErrorDetails = () => import('../entities/mensaje-error/mensaje-error-details.vue');
// prettier-ignore
const Instruccion = () => import('../entities/instruccion/instruccion.vue');
// prettier-ignore
const InstruccionUpdate = () => import('../entities/instruccion/instruccion-update.vue');
// prettier-ignore
const InstruccionDetails = () => import('../entities/instruccion/instruccion-details.vue');
// prettier-ignore
const Link = () => import('../entities/link/link.vue');
// prettier-ignore
const LinkUpdate = () => import('../entities/link/link-update.vue');
// prettier-ignore
const LinkDetails = () => import('../entities/link/link-details.vue');
// prettier-ignore
const Paso = () => import('../entities/paso/paso.vue');
// prettier-ignore
const PasoUpdate = () => import('../entities/paso/paso-update.vue');
// prettier-ignore
const PasoDetails = () => import('../entities/paso/paso-details.vue');
// prettier-ignore
const Usuario = () => import('../entities/usuario/usuario.vue');
// prettier-ignore
const UsuarioUpdate = () => import('../entities/usuario/usuario-update.vue');
// prettier-ignore
const UsuarioDetails = () => import('../entities/usuario/usuario-details.vue');
// prettier-ignore
const Notificacion = () => import('../entities/notificacion/notificacion.vue');
// prettier-ignore
const NotificacionUpdate = () => import('../entities/notificacion/notificacion-update.vue');
// prettier-ignore
const NotificacionDetails = () => import('../entities/notificacion/notificacion-details.vue');
// jhipster-needle-add-entity-to-router-import - JHipster will import entities to the router here

Vue.use(Router);

// prettier-ignore
export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/forbidden',
      name: 'Forbidden',
      component: Error,
      meta: { error403: true }
    },
    {
      path: '/not-found',
      name: 'NotFound',
      component: Error,
      meta: { error404: true }
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/activate',
      name: 'Activate',
      component: Activate
    },
    {
      path: '/reset/request',
      name: 'ResetPasswordInit',
      component: ResetPasswordInit
    },
    {
      path: '/reset/finish',
      name: 'ResetPasswordFinish',
      component: ResetPasswordFinish
    },
    {
      path: '/account/password',
      name: 'ChangePassword',
      component: ChangePassword,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/account/settings',
      name: 'Settings',
      component: Settings,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/admin/user-management',
      name: 'JhiUser',
      component: JhiUserManagementComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    },
    {
      path: '/admin/user-management/new',
      name: 'JhiUserCreate',
      component: JhiUserManagementEditComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    },
    {
      path: '/admin/user-management/:userId/edit',
      name: 'JhiUserEdit',
      component: JhiUserManagementEditComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    },
    {
      path: '/admin/user-management/:userId/view',
      name: 'JhiUserView',
      component: JhiUserManagementViewComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    },
    {
      path: '/admin/docs',
      name: 'JhiDocsComponent',
      component: JhiDocsComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    },
    {
      path: '/admin/audits',
      name: 'JhiAuditsComponent',
      component: JhiAuditsComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    },
    {
      path: '/admin/jhi-health',
      name: 'JhiHealthComponent',
      component: JhiHealthComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    },
    {
      path: '/admin/logs',
      name: 'JhiLogsComponent',
      component: JhiLogsComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    },
    {
      path: '/admin/jhi-metrics',
      name: 'JhiMetricsComponent',
      component: JhiMetricsComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    },
    {
      path: '/admin/jhi-configuration',
      name: 'JhiConfigurationComponent',
      component: JhiConfigurationComponent,
      meta: { authorities: ['ROLE_ADMIN'] }
    }
    ,
    {
      path: '/entity/mensaje-error',
      name: 'MensajeError',
      component: MensajeError,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/mensaje-error/new',
      name: 'MensajeErrorCreate',
      component: MensajeErrorUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/mensaje-error/:mensajeErrorId/edit',
      name: 'MensajeErrorEdit',
      component: MensajeErrorUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/mensaje-error/:mensajeErrorId/view',
      name: 'MensajeErrorView',
      component: MensajeErrorDetails,
      meta: { authorities: ['ROLE_USER'] }
    }
    ,
    {
      path: '/entity/instruccion',
      name: 'Instruccion',
      component: Instruccion,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/instruccion/new',
      name: 'InstruccionCreate',
      component: InstruccionUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/instruccion/:instruccionId/edit',
      name: 'InstruccionEdit',
      component: InstruccionUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/instruccion/:instruccionId/view',
      name: 'InstruccionView',
      component: InstruccionDetails,
      meta: { authorities: ['ROLE_USER'] }
    }
    ,
    {
      path: '/entity/link',
      name: 'Link',
      component: Link,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/link/new',
      name: 'LinkCreate',
      component: LinkUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/link/:linkId/edit',
      name: 'LinkEdit',
      component: LinkUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/link/:linkId/view',
      name: 'LinkView',
      component: LinkDetails,
      meta: { authorities: ['ROLE_USER'] }
    }
    ,
    {
      path: '/entity/paso',
      name: 'Paso',
      component: Paso,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/paso/new',
      name: 'PasoCreate',
      component: PasoUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/paso/:pasoId/edit',
      name: 'PasoEdit',
      component: PasoUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/paso/:pasoId/view',
      name: 'PasoView',
      component: PasoDetails,
      meta: { authorities: ['ROLE_USER'] }
    }
    ,
    {
      path: '/entity/usuario',
      name: 'Usuario',
      component: Usuario,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/usuario/new',
      name: 'UsuarioCreate',
      component: UsuarioUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/usuario/:usuarioId/edit',
      name: 'UsuarioEdit',
      component: UsuarioUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/usuario/:usuarioId/view',
      name: 'UsuarioView',
      component: UsuarioDetails,
      meta: { authorities: ['ROLE_USER'] }
    }
    ,
    {
      path: '/entity/notificacion',
      name: 'Notificacion',
      component: Notificacion,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/notificacion/new',
      name: 'NotificacionCreate',
      component: NotificacionUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/notificacion/:notificacionId/edit',
      name: 'NotificacionEdit',
      component: NotificacionUpdate,
      meta: { authorities: ['ROLE_USER'] }
    },
    {
      path: '/entity/notificacion/:notificacionId/view',
      name: 'NotificacionView',
      component: NotificacionDetails,
      meta: { authorities: ['ROLE_USER'] }
    }
    // jhipster-needle-add-entity-to-router - JHipster will add entities to the router here
  ]
});
