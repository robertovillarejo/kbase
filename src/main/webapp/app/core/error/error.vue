<template>
<div>
  <div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
       <h1 v-text="$t('error.title')">Error Page!</h1>
    </div>
    <div class="col-md-2"></div>
  </div>
  <div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
      <div v-if="errorMessage">
        <div class="alert alert-danger">{{errorMessage}}</div>
      </div>
        <div v-if="error403" class="alert alert-danger" v-text="$t('error.http.403')">You are not authorized to access this page.</div>
        <div v-if="error404" class="alert alert-warning" v-text="$t('error.http.404')">The page you requested does not exist.</div>
    </div>
    <div class="col-md-4"></div>
  </div>
</div>
</template>

<script lang="ts" src="./error.component.ts">
</script>
