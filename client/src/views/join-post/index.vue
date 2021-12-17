<template>
	<div class="jp-container full">
		<TopBar :to="'/post/' + route.params.id" title="申请加入帖子" />
		<van-form @submit="submit">
			<van-field
				v-model="formData.batOffer"
				name="batOffer"
				label="能提供球拍数目"
				type="number"
				placeholder="能提供球拍数目"
				:rules="[{ required: true, message: '请填写能提供的球拍数目' }]"
			/>

			<van-field
				v-model="formData.ballOffer"
				name="ballOffer"
				label="能提供球数目"
				type="number"
				placeholder="能提供球数目"
				:rules="[{ required: true, message: '请填写能提供的球数目' }]"
			/>
			<van-field
				v-model="formData.position"
				name="position"
				label="场上位置"
				type="text"
				placeholder="场上位置"
			/>
			<div style="margin: 16px">
				<van-button round block type="info" native-type="submit"
					>发送申请</van-button
				>
			</div>
		</van-form>
	</div>
</template>
<script lang="ts" setup>
import TopBar from "@/components/top-bar/index.vue";
import { useRoute, useRouter } from "vue-router";
import { reactive } from "vue";
import { useStore } from "vuex";
import { StateProp } from "@/store";
import { postJoinPost } from "@/htpp/post";
import { Toast } from "vant";
const route = useRoute();

const store = useStore<StateProp>();
const formData = reactive({
	joinerId: store.state.userId,
	ballOffer: 0,
	batOffer: 0,
	position: "",
	postId: route.params.id,
});
const router = useRouter();
const submit = async (value: any) => {
	if (await postJoinPost(formData)) {
		Toast.success("申请成功");
		router.back();
	}
};
</script>
<style scoped>
.jp-container {
	padding-top: 40px;
}
.van-cell {
	height: 60px;
}
</style>
