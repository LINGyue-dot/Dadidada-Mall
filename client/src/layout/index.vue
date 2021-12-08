<template>
	<div class="app">
		<div class="content">
			<router-view></router-view>
		</div>
		<TabBar />
	</div>
</template>
<script lang="ts" setup>
import TabBar from "@/components/tab-bar/index.vue";
</script>
<style scoped>
.app {
	height: 100vh;
	width: 100vw;
	box-sizing: border-box;
	display: flex;
	padding-bottom: 60px;
}
.content {
	width: 100%;
	height: 100%;
}
</style>
