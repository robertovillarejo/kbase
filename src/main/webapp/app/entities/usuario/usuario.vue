<template>
    <div>
        <h2 id="page-heading">
            <span v-text="$t('kbaseApp.usuario.home.title')" id="usuario-heading">Usuarios</span>
            <router-link :to="{name: 'UsuarioCreate'}" tag="button" id="jh-create-entity" class="btn btn-primary float-right jh-create-entity create-usuario">
                <font-awesome-icon icon="plus"></font-awesome-icon>
                <span  v-text="$t('kbaseApp.usuario.home.createLabel')">
                    Create a new Usuario
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
        <div class="alert alert-warning" v-if="!isFetching && usuarios && usuarios.length === 0">
            <span v-text="$t('kbaseApp.usuario.home.notFound')">No usuarios found</span>
        </div>
        <div class="table-responsive" v-if="usuarios && usuarios.length > 0">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th v-on:click="changeOrder('id')"><span v-text="$t('global.field.id')">ID</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('nombre')"><span v-text="$t('kbaseApp.usuario.nombre')">Nombre</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('primerApellido')"><span v-text="$t('kbaseApp.usuario.primerApellido')">Primer Apellido</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('segundoApellido')"><span v-text="$t('kbaseApp.usuario.segundoApellido')">Segundo Apellido</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('rfc')"><span v-text="$t('kbaseApp.usuario.rfc')">Rfc</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th v-on:click="changeOrder('correo')"><span v-text="$t('kbaseApp.usuario.correo')">Correo</span> <font-awesome-icon icon="sort"></font-awesome-icon></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="usuario in usuarios"
                    :key="usuario.id">
                    <td>
                        <router-link :to="{name: 'UsuarioView', params: {usuarioId: usuario.id}}">{{usuario.id}}</router-link>
                    </td>
                    <td>{{usuario.nombre}}</td>
                    <td>{{usuario.primerApellido}}</td>
                    <td>{{usuario.segundoApellido}}</td>
                    <td>{{usuario.rfc}}</td>
                    <td>{{usuario.correo}}</td>
                    <td class="text-right">
                        <div class="btn-group">
                            <router-link :to="{name: 'UsuarioView', params: {usuarioId: usuario.id}}" tag="button" class="btn btn-info btn-sm details">
                                <font-awesome-icon icon="eye"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.view')">View</span>
                            </router-link>
                            <router-link :to="{name: 'UsuarioEdit', params: {usuarioId: usuario.id}}"  tag="button" class="btn btn-primary btn-sm edit">
                                <font-awesome-icon icon="pencil-alt"></font-awesome-icon>
                                <span class="d-none d-md-inline" v-text="$t('entity.action.edit')">Edit</span>
                            </router-link>
                            <b-button v-on:click="prepareRemove(usuario)"
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
            <span slot="modal-title"><span id="kbaseApp.usuario.delete.question" v-text="$t('entity.delete.title')">Confirm delete operation</span></span>
            <div class="modal-body">
                <p id="jhi-delete-usuario-heading" v-bind:title="$t('kbaseApp.usuario.delete.question')">Are you sure you want to delete this Usuario?</p>
            </div>
            <div slot="modal-footer">
                <button type="button" class="btn btn-secondary" v-text="$t('entity.action.cancel')" v-on:click="closeDialog()">Cancel</button>
                <button type="button" class="btn btn-primary" id="jhi-confirm-delete-usuario" v-text="$t('entity.action.delete')" v-on:click="removeUsuario()">Delete</button>
            </div>
        </b-modal>
        <div v-show="usuarios && usuarios.length > 0">
            <div class="row justify-content-center">
                <jhi-item-count :page="page" :total="queryCount" :itemsPerPage="itemsPerPage"></jhi-item-count>
            </div>
            <div class="row justify-content-center">
                <b-pagination size="md" :total-rows="totalItems" v-model="page" :per-page="itemsPerPage" :change="loadPage(page)"></b-pagination>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./usuario.component.ts">
</script>
