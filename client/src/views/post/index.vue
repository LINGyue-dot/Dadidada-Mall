<template>
	<div class="post-continer full">
		<template v-if="!loading">
			<TopBar to="/home" title="查看帖子" />
			<template v-if="postInformation">
				<PostItem :item="postInformation" />
			</template>
			<template v-if="showPost()">
				<JoinPostBtn />
			</template>
			<JoinerList />
		</template>
		<template v-else>
			<van-empty image="search" description="搜索中"></van-empty>
		</template>

		<CommentList />

		<CommentInput :post-id="$route.params.id" />
	</div>
</template>
<script lang="ts" setup>
import { getPostDetail, getPostParticipant } from "@/htpp/post";

import { onMounted, ref } from "vue";
import { useRoute } from "vue-router";
import TopBar from "@/components/top-bar/index.vue";
import PostItem from "../home/PostItem.vue";
import JoinPostBtn from "./JoinPostBtn.vue";
import { useStore } from "vuex";
import CommentInput from "@/components/comment/CommentInput.vue";
import CommentList from "@/components/comment/CommentList.vue";
import JoinerList from "./JoinerList.vue";
const route = useRoute();
const postInformation = ref();

const loading = ref(true);
const getPost = async () => {
	postInformation.value = await getPostDetail(route.params.id as string);
};
const participant = ref();
const getParticipant = async () => {
	participant.value = await getPostParticipant(route.params.id as string);
};

const store = useStore();
const showPost = () => {
	console.log(store.state.userId, postInformation.value.initiatorId);
	if (store.state.userId == postInformation.value.initiatorId) {
		return false;
	}
	return true;
};

onMounted(async () => {
	await getPost();
	await getParticipant();
	loading.value = false;
});
</script>
<style scoped>
.post-continer {
	padding-top: 40px;
	overflow-y: scroll;
	position: relative;
	box-sizing: border-box;
}
</style>
