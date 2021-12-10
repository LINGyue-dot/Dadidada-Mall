<template>
	<div class="cin-container" ref="cinRef">
		<input
			ref="inputRef"
			class="cin-input"
			type="text"
			v-model="cText"
			placeholder="留下友善的评论"
		/>
		<div class="cin-submit" @click="submitComment">
			<!-- :class="cText ? 'cin-submit-active' : ''" -->
			发布
		</div>
	</div>
</template>
<script lang="ts" setup>
import { defineComponent, ref, watch } from "vue";
import { postCommentNd, postCommentSt } from "@/htpp/post";
import { useStore } from "vuex";
import { StateProp } from "@/store";
import { Toast } from "vant";

const props = defineProps({
	postId: {
		type: String,
		required: true,
	},
});

const store = useStore<StateProp>();

const cinRef = ref();
const inputRef = ref();

const cText = ref();
const isDad = ref(false);
const sendId = ref<string | number>(props.postId);
const submitComment = async () => {
	if (!sendId.value) {
		return;
	}

	if (isDad.value) {
		// 二级评论
		await postCommentNd({
			dadCommentId: sendId.value,
			userId: store.state.userId,
			commentConten: cText.value,
		});
	} else {
		// 一级评论
		if (
			await postCommentSt({
				postId: sendId.value,
				userId: store.state.userId,
				commentContent: cText.value,
			})
		) {
			Toast({
				message: "评论成功",
				position: "top",
			});
			cText.value = "";
		}
	}
};
const activeComment = (flag: boolean, id: number | string) => {
	isDad.value = flag;
	sendId.value = id;
};

defineExpose({
	activeComment,
});
</script>
<style scoped>
.cin-container {
	transition: all 0.3s linear;
	border-top: solid 1px #eee;
	position: fixed;
	bottom: 0px;
	left: 0;
	z-index: 5;
	height: 40px;
	line-height: 40px;
	width: 100vw;
	display: flex;
	flex-direction: row;
}
.cin-show {
	bottom: 0;
}
.cin-input {
	display: block;
	width: 100%;
	height: 40px;
	line-height: 40px;
	padding: 0 20px;
	border: 0;
}
.cin-submit {
	color: #000;
	background-color: #fff;
	height: 40px;
	width: 60px;
}
.cin-submit-active {
	color: #2ee;
}
</style>
