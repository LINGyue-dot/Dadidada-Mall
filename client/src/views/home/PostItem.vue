<template>
	<div class="pi-container profile-paddding" @click="hanleClick">
		<div class="pi-user">
			<UserSimple
				:user-id="$props.item.initiatorId"
				:timer="JsDateTimer($props.item.postTime)"
			/>
		</div>
		<p class="pi-item">球类：{{ ballName }}</p>
		<p class="pi-item">
			<!-- 地点： -->
		</p>
		<p class="pi-item">
			时间：{{
				`${JsDateTimer($props.item.beginTime)} 至 ${JsDateTimer(
					$props.item.endTime
				)}`
			}}
		</p>
		<p class="pi-item">装备：{{ showBallNeed() }}</p>
		<p class="pi-item">人员：{{ showPeopleNeed() }}</p>
		<p class="pi-item content">{{ $props.item.initiatorNote }}</p>
		<p class="pi-item" @click="showImg">
			<van-image width="150" height="150" :src="$props.item.postImg" />
		</p>
	</div>
</template>
<script lang="ts" setup>
import { onMounted, ref } from "vue";
import UserSimple from "@/components/user-simple/index.vue";
import { JsDateTimer } from "@/util/timer";
import { ImagePreview } from "vant";
import { useStore } from "vuex";
import { useRoute, useRouter } from "vue-router";
const props = defineProps({
	item: Object as any,
});
const store = useStore();
const ballName = ref("");
const showBallName = async () => {
	ballName.value = await store.dispatch("findBall", props.item.ballId);
};
const showBallNeed = () => {
	if (
		props.item.batNeedNumber <= props.item.batOwnedNumber &&
		props.item.ballNeedNumber <= props.item.ballOwnedNumber
	) {
		return "装备已够";
	} else {
		return `当前装备还缺${
			props.item.batNeedNumber > props.item.batOwnedNumber
				? props.item.batNeedNumber - props.item.batOwnedNumber + "拍"
				: ""
		}，${
			props.item.ballNeedNumber > props.item.ballOwnedNumber
				? props.item.ballNeedNumber - props.item.ballOwnedNumber + "球"
				: ""
		}`;
	}
};

const showPeopleNeed = () => {
	if (props.item.peopleMinNumber > props.item.peopleCurrentNumber) {
		return `当前还缺少 ${
			props.item.peopleMinNumber - props.item.peopleCurrentNumber
		}人`;
	} else if (props.item.peopleMaxNumber > props.item.peopleCurrentNumber) {
		return `当前还可加入 ${
			props.item.peopleMaxNumber - props.item.peopleCurrentNumber
		}人`;
	} else {
		return "当前人数已足够";
	}
};
const showImg = () => {
	ImagePreview([props.item.postImg]);
};

const router = useRouter();
const route = useRoute();
const hanleClick = () => {
	if ((route.path = "/home")) {
		router.push("/post/" + props.item.postId);
	}
};

onMounted(() => {
	showBallName();
});
</script>
<style scoped>
.pi-container {
	margin-top: 20px;
	border-bottom: 3px solid #eee;
}
.pi-user {
	margin-bottom: 10px;
}
.pi-item {
}
</style>
