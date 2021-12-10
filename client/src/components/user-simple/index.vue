<template>
	<div class="ui-container">
		<div class="left">
			<UserAvatar :type="AvatarType.MIN" :url="url" />
		</div>
		<div class="right">
			<h2 class="name">
				{{ name }}
				<span class="time"> <slot name="time"></slot></span>
			</h2>
			<div class="bottom">
				<slot name="bottom"></slot>
			</div>
		</div>
	</div>
</template>
<script lang="ts" setup>
import { getUserInfo } from "@/htpp/api";
import { ref, onMounted } from "vue";
import UserAvatar, { AvatarType } from "../avatar/UserAvatar.vue";

const url = ref("");
const name = ref("suger");
const props = defineProps({
	userId: String,
});

const getUser = async () => {
	getUserInfo(props.userId as string).then(res => {
		console.log(res);
		url.value = res.data.userAvatar;
		name.value = res.data.userName;
	});
};

onMounted(() => {
	getUser();
});
</script>

<style scoped>
.ui-container {
	display: flex;
	flex-direction: row;
	width: 100%;
	height: 40px;
}
.left {
	width: 40px;
}
.right {
	flex: 1;
	display: flex;
	flex-direction: column;
}
.time {
	float: right;
}
.name {
	position: relative;
	flex: 1;
}
.bottom {
	flex: 1;
}
</style>
