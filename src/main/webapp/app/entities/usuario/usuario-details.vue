<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="usuario">
                <h2 class="jh-entity-heading"><span v-text="$t('kbaseApp.usuario.detail.title')">Usuario</span> {{usuario.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('kbaseApp.usuario.nombre')">Nombre</span>
                    </dt>
                    <dd>
                        <span>{{usuario.nombre}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('kbaseApp.usuario.primerApellido')">Primer Apellido</span>
                    </dt>
                    <dd>
                        <span>{{usuario.primerApellido}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('kbaseApp.usuario.segundoApellido')">Segundo Apellido</span>
                    </dt>
                    <dd>
                        <span>{{usuario.segundoApellido}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('kbaseApp.usuario.rfc')">Rfc</span>
                    </dt>
                    <dd>
                        <span>{{usuario.rfc}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('kbaseApp.usuario.correo')">Correo</span>
                    </dt>
                    <dd>
                        <span>{{usuario.correo}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="usuario.id" :to="{name: 'UsuarioEdit', params: {usuarioId: usuario.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./usuario-details.component.ts">
</script>
