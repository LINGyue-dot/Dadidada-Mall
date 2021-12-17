<template>
	<div class="st-container" :class="'tag-' + $props.state">{{ stateText }}</div>
</template>
<script lang="ts" setup>
import { computed } from "vue";

const props = defineProps({
	state: Number,
});

const stateText = computed(() => {
	switch (props.state) {
		case 0:
			return "待开";
		case 1:
			return "已开可加入";
		case 2:
			return "已开不可加入";
		case 3:
			return "结束";
		default:
			break;
	}
});
</script>
<style scoped>
.st-container {
	position: absolute;
	right: -60px;
	bottom: 10px;
	width: 200px;
	height: 35px;
	line-height: 35px;
	text-align: center;
	transform: rotate(-30deg);
	color: #fff;
}
.tag-0 {
	background-color: rgba(0, 0, 0, 0.8);
}

.tag-1 {
	background-color: rgba(0, 0, 0, 0.6);
}
.tag-2 {
	background-color: rgba(0, 0, 0, 0.4);
}
.tag-3 {
	background-color: rgba(0, 0, 0, 0.2);
}
</style>
