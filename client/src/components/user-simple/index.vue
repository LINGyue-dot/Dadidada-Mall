<template>
	<div
		class="ui-container"
		:class="{ primary: $props.imgType === AvatarType.PRIMARY }"
	>
		<div
			class="left"
			:class="{ 'left-primary': $props.imgType === AvatarType.PRIMARY }"
		>
			<UserAvatar :type="$props.imgType" :url="url" />
		</div>
		<div class="right">
			<h5 class="name">
				{{ name }}
				<span class="time"> {{ $props.timer }}</span>
			</h5>
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
	userId: Number,
	timer: String,
	imgType: {
		type: String,
		default: () => AvatarType.MIN,
	},
});

const getUser = async () => {
	getUserInfo(props.userId?.toString() as string).then(res => {
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
}
.left {
	width: 50px;
	height: 50px;
}
.right {
	flex: 1;
	display: flex;
	flex-direction: column;

	padding-left: 20px;
}
.time {
	display: inline-block;
	position: absolute;
	right: 10px;
	top: 50%;
	transform: translateY(-50%);
	font-size: 14px;
	color: rgb(87, 72, 72);
}
.name {
	position: relative;
	flex: 1;
}
.primary {
	height: 40px;
}
.left-primary {
	height: 40px;
}
.bottom {
	flex: 1;
}
</style>
