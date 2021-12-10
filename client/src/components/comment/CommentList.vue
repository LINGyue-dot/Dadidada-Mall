<template>
	<van-pull-refresh
		v-model="refreshing"
		@refresh="onRefresh"
		class="profile-paddding"
	>
		<van-list
			v-model:loading="loading"
			:finished="finished"
			finished-text="没有更多了"
			@load="onLoad"
		>
			<div class="cl-item" v-for="item in list" :key="item" :title="item">
				<UserSimple
					:user-id="item.userId"
					:timer="JsDateTimer(item.postTime)"
					:img-type="AvatarType.PRIMARY"
				/>
				<p class="content">{{ item.commentContent }}</p>
			</div>
		</van-list>
	</van-pull-refresh>
</template>
<script lang="ts" setup>
import { ref } from "vue";
import { usePage } from "@/hooks/usePageHook";
import { getCommentSt } from "@/htpp/post";
import { useRoute } from "vue-router";
import UserSimple from "../user-simple/index.vue";
import { JsDateTimer } from "@/util/timer";
import { AvatarType } from "../avatar/UserAvatar.vue";
const { pageSize, pageNum, nextPage, initPage } = usePage();
const route = useRoute();
const list = ref<any[]>([]);
const loading = ref(false);
const finished = ref(false);
const refreshing = ref(false);
const onLoad = async () => {
	getCommentSt(
		pageSize.value,
		pageNum.value,

		// @ts-ignore
		route.params.id
	).then(res => {
		if (refreshing.value) {
			//
			refreshing.value = false;
		}
		if (res.list.length <= 0) {
			finished.value = true;
			return;
		}
		list.value.push(...res.list);
		loading.value = false;
	});
	nextPage();
};

const onRefresh = () => {
	// 清空列表数据
	finished.value = false;
	list.value = [];
	initPage();

	// 重新加载数据
	// 将 loading 设置为 true，表示处于加载状态
	loading.value = true;
	onLoad();
};
</script>
<style scoped>
.content {
	padding-left: 70px;
	word-break: break-all;
}
.cl-item {
	margin-top: 20px;
	border-bottom: solid 2px #eee;
}
</style>
