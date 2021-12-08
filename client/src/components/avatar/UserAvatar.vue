<template>
	<img class="avatar" :src="$props.url" :class="'img-' + $props.type" />
</template>
<script lang="ts">
export enum AvatarType {
	MIN = "MIN",
	LARGE = "LARGE",
}
</script>
<script lang="ts" setup>
import { PropType, defineProps } from "vue";

defineProps({
	url: String,
	type: String as PropType<AvatarType>,
});
</script>
<style scoped>
.avatar {
	object-fit: fill;
	border-radius: 50%;
	overflow: hidden;
}
.img-MIN {
}
.img-LARGE {
	width: 70px;
	height: 70px;
}
</style>
