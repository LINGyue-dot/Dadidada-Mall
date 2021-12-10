<template>
	<div class="pi-container">
		<UserSimple :user-id="item.initiatorId" />
	</div>
</template>
<script lang="ts" setup>
import { onMounted } from "vue";
import UserSimple from "@/components/user-simple/index.vue";
const props = defineProps({
	item: Object as any,
});
onMounted(() => {
	console.log(props.item);
});
</script>
<style scoped></style>
