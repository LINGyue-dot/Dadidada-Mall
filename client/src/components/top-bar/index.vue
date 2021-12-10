<template>
	<div class="tb-container">
		<div class="tb-back">
			<BackTop :to="$props.to" />
		</div>
		<div class="title">{{ $props.title }}</div>
	</div>
</template>
<script lang="ts" setup>
import BackTop from "../back-top/index.vue";
defineProps({
	to: String,
	title: String,
});
</script>
<style scoped>
.tb-container {
	width: 100%;
	height: 40px;
	display: flex;
	align-items: center;
	justify-content: center;
	position: fixed;
	top: 0;
	left: 0;
}

.tb-back {
	position: absolute;
	left: 10px;
	line-height: 40px;
	height: 40px;
}
.title {
	font-size: 20px;
}
</style>
