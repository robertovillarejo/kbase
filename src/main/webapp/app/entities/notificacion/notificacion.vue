<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('kbaseApp.notificacion.home.title')" id="notificacion-heading">Notificacions</span>
            <router-link :to="{name: 'NotificacionCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-notificacion">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('kbaseApp.notificacion.home.createLabel')">
                    Create a new Notificacion
                </span>
            </router-link>
        </h2>
        <b-alert :show="dismissCountDown"
            dismissible
            :variant="alertType"
            @dismissed="dismissCountDown=0"
            @dismiss-count-down="countDownChanged">
            {{alertMessage}}
        </b-alert>
        <br/>
        <div class="alert alert-warning" v-if="!isFetching && notificacions && notificacions.length === 0">
            <span v-text="$t('kbaseApp.notificacion.home.notFound')">No notificacions found</span>
        </div>
        <div class="table-responsive" v-if="notificacions && notificacions.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('destinatarios')"><span v-text="$t('kbaseApp.notificacion.destinatarios')">Destinatarios</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('remitente')"><span v-text="$t('kbaseApp.notificacion.remitente')">Remitente</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('fechaEnvio')"><span v-text="$t('kbaseApp.notificacion.fechaEnvio')">Fecha Envio</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('asunto')"><span v-text="$t('kbaseApp.notificacion.asunto')">Asunto</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('mensaje')"><span v-text="$t('kbaseApp.notificacion.mensaje')">Mensaje</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('cc')"><span v-text="$t('kbaseApp.notificacion.cc')">Cc</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('cco')"><span v-text="$t('kbaseApp.notificacion.cco')">Cco</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="notificacion in notificacions"
                    :key="notificacion.id">
                    <td>
                        <router-link :to="{name: 'NotificacionView', params: {notificacionId: notificacion.id}}">{{notificacion.id}}</router-link>
                    </td>
                    <td>{{notificacion.destinatarios}}</td>
                    <td>{{notificacion.remitente}}</td>
                    <td>{{notificacion.fechaEnvio | formatDate}}</td>
                    <td>{{notificacion.asunto}}</td>
                    <td>{{notificacion.mensaje}}</td>
                    <td>{{notificacion.cc}}</td>
                    <td>{{notificacion.cco}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'NotificacionView', params: {notificacionId: notificacion.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'NotificacionEdit', params: {notificacionId: notificacion.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(notificacion)"
                                   variant="danger"
                                   class="btn btn-sm"
                                   v-b-modal.removeEntity>
                                <font-awesome-icon icon="times"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.delete')">Delete</span>
                            </b-button>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <b-modal ref="removeEntity" id="removeEntity" >
            <span slot="modal-title"><span id="kbaseApp.notificacion.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-notificacion-heading" v-bind:title="$t('kbaseApp.notificacion.delete.question')">Are you sure you want to delete this Notificacion?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-notificacion" v-text="$t('entity.action.delete')" v-on:click="removeNotificacion()">Delete</button>
            </div>
        </b-modal>
        <div v-show="notificacions && notificacions.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./notificacion.component.ts">
</script>
