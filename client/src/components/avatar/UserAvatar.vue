<template>
	<img class="avatar" :src="$props.url" :class="'img-' + $props.type" />
</template>
<script lang="ts">
export enum AvatarType {
	MIN = "MIN",
	PRIMARY = "PRIMARY",
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
	width: 100%;
	height: 100%;
}
.img-LARGE {
	width: 70px;
	height: 70px;
}
.img-PRIMARY {
	width: 40px;
	height: 40px;
}
</style>
