<template>
    <div class="row justify-content-center">
        <div class="col-8">
            <div v-if="notificacion">
                <h2 class="jh-entity-heading"><span v-text="$t('kbaseApp.notificacion.detail.title')">Notificacion</span> {{notificacion.id}}</h2>
                <dl class="row jh-entity-details">
                    <dt>
                        <span v-text="$t('kbaseApp.notificacion.destinatarios')">Destinatarios</span>
                    </dt>
                    <dd>
                        <span>{{notificacion.destinatarios}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('kbaseApp.notificacion.remitente')">Remitente</span>
                    </dt>
                    <dd>
                        <span>{{notificacion.remitente}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('kbaseApp.notificacion.fechaEnvio')">Fecha Envio</span>
                    </dt>
                    <dd>
                        <span>{{notificacion.fechaEnvio | formatDate}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('kbaseApp.notificacion.asunto')">Asunto</span>
                    </dt>
                    <dd>
                        <span>{{notificacion.asunto}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('kbaseApp.notificacion.mensaje')">Mensaje</span>
                    </dt>
                    <dd>
                        <span>{{notificacion.mensaje}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('kbaseApp.notificacion.cc')">Cc</span>
                    </dt>
                    <dd>
                        <span>{{notificacion.cc}}</span>
                    </dd>
                    <dt>
                        <span v-text="$t('kbaseApp.notificacion.cco')">Cco</span>
                    </dt>
                    <dd>
                        <span>{{notificacion.cco}}</span>
                    </dd>
                </dl>
                <button type="submit"
                        v-on:click.prevent="previousState()"
                        class="btn btn-info">
                    <font-awesome-icon icon="arrow-left"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.back')"> Back</span>
                </button>
                <router-link v-if="notificacion.id" :to="{name: 'NotificacionEdit', params: {notificacionId: notificacion.id}}" tag="button" class="btn btn-primary">
                    <font-awesome-icon icon="pencil-alt"></font-awesome-icon>&nbsp;<span v-text="$t('entity.action.edit')"> Edit</span>
                </router-link>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./notificacion-details.component.ts">
</script>
