<template>
	<div class="a-contaienr full">
		<TopBar to="/profile" title="申请列表" />
		<div class="a-list">
			<van-list
				v-model:loading="loading"
				:finished="finished"
				finished-text="没有更多了"
				@load="onLoad"
			>
				<div
					class="a-item"
					v-for="item in list"
					:key="item"
					@click.prevent="hanleClick(item.postId, item.joinerId, $event)"
				>
					<UserSimple :user-id="item.joinerId" :img-type="AvatarType.PRIMARY" />
					<p class="a-p">
						{{
							`所能提供球数目${item.ballOffer}，所能提供球拍的数目${item.batOffer}`
						}}
					</p>
					<router-link class="a-a" :to="'/post/' + item.postId"
						>查看详情</router-link
					>
				</div>
			</van-list>
		</div>
	</div>
</template>
<script lang="ts" setup>
import { ref } from "vue";
import TopBar from "@/components/top-bar/index.vue";
import { getApplicant, solvePost } from "@/htpp/post";
import UserSimple from "@/components/user-simple/index.vue";
import { AvatarType } from "@/components/avatar/UserAvatar.vue";
import { Dialog, Toast } from "vant";
const list = ref([]);
const loading = ref(false);
const finished = ref(false);

const onLoad = async () => {
	const data = await getApplicant();
	list.value = [];
	list.value.push(...data);
	// 加载状态结束
	loading.value = false;
	finished.value = true;
};
const hanleClick = (postId: number, joinerId: number, e: Event) => {
	e.stopPropagation();
	e.stopImmediatePropagation();
	Dialog.confirm({
		title: "是否同意该用户",
		message: "确认即同意该用户加入，取消即拒绝该用户加入",
	})
		.then(() => {
			solvePost(postId, joinerId, true).then(res => {
				Toast.success("同意该用户加入成功");
			});
		})
		.catch(() => {
			solvePost(postId, joinerId, false).then(res => {
				Toast.fail("拒绝该用户加入成功");
			});
		})
		.finally(() => {
			onLoad();
		});
};
</script>
<style scoped>
.a-contaienr {
	padding-top: 40px;
}
.a-list {
	width: 100%;
	height: 100%;
	overflow-y: scroll;
}
.a-item {
	margin-top: 20px;
	border-bottom: solid 2px #eee;
}
.a-p {
	padding-left: 70px;
	box-sizing: border-box;
	width: 100%;
	margin: 5px 0;
}

.a-a {
	padding-left: 70px;
	display: block;
}
</style>
