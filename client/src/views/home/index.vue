<template>
	<van-pull-refresh v-model="refreshing" @refresh="onRefresh">
		<van-list
			v-model:loading="loading"
			:finished="finished"
			finished-text="没有更多了"
			@load="onLoad"
		>
			<PostItem v-for="item in list" :key="item" :item="item" />
		</van-list>
	</van-pull-refresh>
</template>
<script lang="ts" setup>
import { usePage } from "@/hooks/usePageHook";
import { getPostList } from "@/htpp/post";
import { ref, onMounted } from "vue";
import PostItem from "./PostItem.vue";
const { pageSize, pageNum, nextPage, initPage } = usePage();

const refreshing = ref(false);
const loading = ref(true);
const finished = ref(false);
const list = ref([]);

// 刷新
const onRefresh = () => {
	initPage();
};

// 加载更多
const onLoad = async () => {
	const res = (await getPostList(pageSize.value, pageNum.value)) as any;
	if (!res.list || !res.list.length) {
		finished.value = true;
	}
	// @ts-ignore
	list.value.push(...res.list);
	nextPage();
	// loading.value = false;
	console.log(list.value);
};

onMounted(() => {});
</script>
<style scoped></style>
