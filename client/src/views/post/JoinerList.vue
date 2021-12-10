<template>
	<div class="show-list profile-paddding" @click="showAction = true">
		参与者列表
	</div>
	<van-action-sheet v-model:show="showAction" title="参与者列表">
		<template v-if="list.length == 0">
			<van-empty image="search" description="暂无数据"
		/></template>
		<template v-else>
			<div v-for="item in list">
				<UserSimple :user-id="item.userId" :img-type="AvatarType.PRIMARY" />
			</div>
		</template>
	</van-action-sheet>
</template>
<script lang="ts" setup>
import { AvatarType } from "@/components/avatar/UserAvatar.vue";
import { getPostParticipant } from "@/htpp/post";
import { JsDateTimer } from "@/util/timer";
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";
const showAction = ref(false);
const route = useRoute();
const list = ref<any[]>([]);
onMounted(async () => {
	list.value = await getPostParticipant(route.params.id);
});
</script>
<style scoped>
.show-list {
	height: 30px;
	line-height: 30px;
	width: 100%;
	color: #000;
	box-sizing: border-box;
	background-color: #eee;
	text-align: center;
}
</style>
