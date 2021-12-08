<template>
	<div class="container">
		<div class="iconfont icon">{{ $props.iconContent }}</div>
		<div class="title">{{ $props.title }}</div>
	</div>
</template>
<script lang="ts" setup>
defineProps({
	iconContent: String,
	title: String,
});
</script>
<style scoped>
.container {
	width: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}
.icon {
	flex: 7;
	font-size: 40px;
}

.title {
	flex: 2;
}
</style>
