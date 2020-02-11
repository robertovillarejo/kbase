<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="kbaseApp.notificacion.home.createOrEditLabel" v-text="$t('kbaseApp.notificacion.home.createOrEditLabel')">Create or edit a Notificacion</h2>
                <div>
                    <div class="form-group" v-if="notificacion.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="notificacion.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('kbaseApp.notificacion.destinatarios')" for="notificacion-destinatarios">Destinatarios</label>
                        <input type="text" class="form-control" name="destinatarios" id="notificacion-destinatarios"
                            :class="{'valid': !$v.notificacion.destinatarios.$invalid, 'invalid': $v.notificacion.destinatarios.$invalid }" v-model="$v.notificacion.destinatarios.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('kbaseApp.notificacion.remitente')" for="notificacion-remitente">Remitente</label>
                        <input type="text" class="form-control" name="remitente" id="notificacion-remitente"
                            :class="{'valid': !$v.notificacion.remitente.$invalid, 'invalid': $v.notificacion.remitente.$invalid }" v-model="$v.notificacion.remitente.$model" />
                        <div v-if="$v.notificacion.remitente.$anyDirty && $v.notificacion.remitente.$invalid">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('kbaseApp.notificacion.fechaEnvio')" for="notificacion-fechaEnvio">Fecha Envio</label>
                        <div class="d-flex">
                            <input id="notificacion-fechaEnvio" type="datetime-local" class="form-control" name="fechaEnvio" :class="{'valid': !$v.notificacion.fechaEnvio.$invalid, 'invalid': $v.notificacion.fechaEnvio.$invalid }"
                            
                            :value="convertDateTimeFromServer($v.notificacion.fechaEnvio.$model)"
                            @change="updateInstantField('fechaEnvio', $event)"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('kbaseApp.notificacion.asunto')" for="notificacion-asunto">Asunto</label>
                        <input type="text" class="form-control" name="asunto" id="notificacion-asunto"
                            :class="{'valid': !$v.notificacion.asunto.$invalid, 'invalid': $v.notificacion.asunto.$invalid }" v-model="$v.notificacion.asunto.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('kbaseApp.notificacion.mensaje')" for="notificacion-mensaje">Mensaje</label>
                        <input type="text" class="form-control" name="mensaje" id="notificacion-mensaje"
                            :class="{'valid': !$v.notificacion.mensaje.$invalid, 'invalid': $v.notificacion.mensaje.$invalid }" v-model="$v.notificacion.mensaje.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('kbaseApp.notificacion.cc')" for="notificacion-cc">Cc</label>
                        <input type="text" class="form-control" name="cc" id="notificacion-cc"
                            :class="{'valid': !$v.notificacion.cc.$invalid, 'invalid': $v.notificacion.cc.$invalid }" v-model="$v.notificacion.cc.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('kbaseApp.notificacion.cco')" for="notificacion-cco">Cco</label>
                        <input type="text" class="form-control" name="cco" id="notificacion-cco"
                            :class="{'valid': !$v.notificacion.cco.$invalid, 'invalid': $v.notificacion.cco.$invalid }" v-model="$v.notificacion.cco.$model" />
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.notificacion.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./notificacion-update.component.ts">
</script>
