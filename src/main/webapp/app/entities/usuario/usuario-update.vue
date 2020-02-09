<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <form name="editForm" role="form" novalidate v-on:submit.prevent="save()" >
                <h2 id="kbaseApp.usuario.home.createOrEditLabel" v-text="$t('kbaseApp.usuario.home.createOrEditLabel')">Create or edit a Usuario</h2>
                <div>
                    <div class="form-group" v-if="usuario.id">
                        <label for="id" v-text="$t('global.field.id')">ID</label>
                        <input type="text" class="form-control" id="id" name="id"
                               v-model="usuario.id" readonly />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('kbaseApp.usuario.nombre')" for="usuario-nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" id="usuario-nombre"
                            :class="{'valid': !$v.usuario.nombre.$invalid, 'invalid': $v.usuario.nombre.$invalid }" v-model="$v.usuario.nombre.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('kbaseApp.usuario.primerApellido')" for="usuario-primerApellido">Primer Apellido</label>
                        <input type="text" class="form-control" name="primerApellido" id="usuario-primerApellido"
                            :class="{'valid': !$v.usuario.primerApellido.$invalid, 'invalid': $v.usuario.primerApellido.$invalid }" v-model="$v.usuario.primerApellido.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('kbaseApp.usuario.segundoApellido')" for="usuario-segundoApellido">Segundo Apellido</label>
                        <input type="text" class="form-control" name="segundoApellido" id="usuario-segundoApellido"
                            :class="{'valid': !$v.usuario.segundoApellido.$invalid, 'invalid': $v.usuario.segundoApellido.$invalid }" v-model="$v.usuario.segundoApellido.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('kbaseApp.usuario.rfc')" for="usuario-rfc">Rfc</label>
                        <input type="text" class="form-control" name="rfc" id="usuario-rfc"
                            :class="{'valid': !$v.usuario.rfc.$invalid, 'invalid': $v.usuario.rfc.$invalid }" v-model="$v.usuario.rfc.$model" />
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" v-text="$t('kbaseApp.usuario.correo')" for="usuario-correo">Correo</label>
                        <input type="text" class="form-control" name="correo" id="usuario-correo"
                            :class="{'valid': !$v.usuario.correo.$invalid, 'invalid': $v.usuario.correo.$invalid }" v-model="$v.usuario.correo.$model" />
                        <div v-if="$v.usuario.correo.$anyDirty && $v.usuario.correo.$invalid">
                        </div>
                    </div>
                </div>
                <div>
                    <button type="button" id="cancel-save" class="btn btn-secondary" v-on:click="previousState()">
                        <font-awesome-icon icon="ban"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.cancel')">Cancel</span>
                    </button>
                    <button type="submit" id="save-entity" :disabled="$v.usuario.$invalid || isSaving" class="btn btn-primary">
                        <font-awesome-icon icon="save"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.save')">Save</span>
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<script lang="ts" src="./usuario-update.component.ts">
</script>
