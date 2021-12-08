<template>
	<div class="back-top">
		<router-link class="iconfont back-icon" :to="$props.to"
			>&#xe8a4;</router-link
		>
	</div>
</template>
<script lang="ts" setup>
defineProps({
	to: String,
});
</script>
<style scoped>
.back-top {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 40px;
	line-height: 40px;
	padding-left: 10px;
}
.back-icon {
	font-size: 35px;
	color: #000;
}
</style>
