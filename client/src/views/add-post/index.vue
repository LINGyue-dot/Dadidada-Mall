<template>
	<div class="ap-container full">
		<div class="ap-top">
			<TopBar to="/home" title="发布帖子" />
		</div>

		<van-form @submit="submit" style="overflow-y: 'scroll'">
			<van-field
				label="开始时间"
				name="beginTime"
				readonly
				@click="showBeginTime"
				v-model="beginTimerShow"
				:rules="[{ required: true, message: '请选择开始时间' }]"
			></van-field>
			<van-field
				name="endTime"
				label="结束时间"
				readonly
				@click="showEndTime"
				v-model="endTimerShow"
				:rules="[{ required: true, message: '请选择结束时间' }]"
			></van-field>
			<van-field
				v-model="ballName"
				is-link
				readonly
				name="ballId"
				label="球类"
				placeholder="点击选择球类"
				@click="showBall = true"
				:rules="[{ required: true, message: '请填写球类' }]"
			/>
			<van-field
				v-model="formData.batNeedNumber"
				name="batNeedNumber"
				label="球拍所需数目"
				type="number"
				placeholder="球拍所需数目"
				:rules="[{ required: true, message: '请填写所需球拍数目' }]"
			/>

			<van-field
				v-model="formData.ballNeedNumber"
				name="ballNeedNumber"
				label="球所需数目"
				type="number"
				placeholder="球所需数目"
				:rules="[{ required: true, message: '请填写所需球数目' }]"
			/>
			<van-field
				v-model="formData.peopleMinNumber"
				name="peopleMinNumber"
				label="最少人数"
				type="number"
				placeholder="最少人数"
				:rules="[{ required: true, message: '最少人数' }]"
			/>
			<van-field
				v-model="formData.peopleMaxNumber"
				name="peopleMaxNumber"
				label="最多人数"
				type="number"
				placeholder="最多人数"
				:rules="[{ required: true, message: '最多人数' }]"
			/>
			<van-field
				v-model="formData.batOffer"
				name="batOffer"
				label="所能提供的球拍数目"
				type="number"
				placeholder="所能提供的球拍数目"
				:rules="[{ required: true, message: '所能提供的球拍数目' }]"
			/>
			<van-field
				v-model="formData.ballOffer"
				name="ballOffer"
				label="所能提供的球数目"
				type="number"
				placeholder="所能提供的球数目"
				:rules="[{ required: true, message: '所能提供的球数目' }]"
			/>
			<van-field
				v-model="formData.position"
				name="position"
				label="擅长的位置"
				type="text"
				placeholder="擅长的位置"
			/>

			<van-field label="上传图片" :style="{ height: '120px!important' }">
				<template #input>
					<van-uploader
						v-model="imgList"
						:after-read="afterRead"
						:max-count="1"
					>
					</van-uploader>
				</template>
			</van-field>

			<van-popup v-model:show="showBall" position="bottom">
				<van-picker
					:columns="ballList"
					@confirm="ballConfirm"
					@cancel="showBall = false"
				/>
			</van-popup>

			<van-field
				v-model="formData.initiatorNote"
				rows="3"
				name="initiatorNote"
				autosize
				label="留言"
				type="textarea"
				maxlength="200"
				placeholder="请输入留言"
				show-word-limit
				:style="{ height: '150px!important' }"
			/>

			<div style="margin: 16px">
				<van-button round block type="info" native-type="submit"
					>发送帖子</van-button
				>
			</div>
		</van-form>

		<TimePicker ref="timerRef" @emit-timer="emitTimer" />
	</div>
</template>
<script lang="ts" setup>
import { ref, computed, reactive, onMounted, unref } from "vue";
import TopBar from "@/components/top-bar/index.vue";
import TimePicker from "@/components/time-picker/index.vue";
import { JsDateTimer } from "@/util/timer";
import { useStore } from "vuex";
import { StateProp } from "@/store";
import { AddPostProp } from "@/types/types";
import { addPost, getBallList } from "@/htpp/post";
import { UploadImg } from "@/htpp/upload";
import { useRouter } from "vue-router";
import { Toast } from "vant";

const store = useStore<StateProp>();
const router = useRouter();
const timerRef = ref();
const showBeginTime = () => {
	isBegin.value = true;
	timerRef.value.showTimerPicker();
};
const showEndTime = () => {
	isBegin.value = false;
	timerRef.value.showTimerPicker();
};

const beginTime = ref();
const endTime = ref();
const isBegin = ref(true);

const beginTimerShow = computed(() => JsDateTimer(beginTime.value));
const endTimerShow = computed(() => JsDateTimer(endTime.value));

const emitTimer = (date: string) => {
	const temp = new Date(date).getTime();
	if (isBegin.value) {
		beginTime.value = temp;
	} else {
		endTime.value = temp;
	}
};

const formData = reactive<Partial<AddPostProp>>({
	initiatorId: store.state.userId,
	reverseId: undefined,
	postImg: undefined,
	ballId: 1,
	batNeedNumber: undefined,
	ballNeedNumber: undefined,
	peopleMinNumber: undefined,
	peopleMaxNumber: undefined,
	initiatorNote: undefined,
	batOffer: undefined,
	ballOffer: undefined,
	position: undefined,
});

const ballName = ref("");
const ballList = ref();
const showBall = ref(false);
const getBall = async () => {
	ballList.value = (await getBallList()).map((item: any) => item.ballType);
};
const ballConfirm = (value: any, index: number) => {
	ballName.value = value;
	formData.ballId = index + 1;
	showBall.value = false;
	console.log(formData.ballId);
};

onMounted(() => {
	getBall();
});

const imgList = ref([]);
const afterRead = (file: any) => {
	file.status = "uploading";
	file.message = "上传中";
	console.log(file);
	const data = unref(file.file);
	console.log(data);
	UploadImg(data)
		.then((res: any) => {
			file.url = res.data.url;
			file.status = "success";
		})
		.then(err => console.log(err));
};

const submit = async (val: any) => {
	const data = {
		...val,
		beginTime: beginTime.value.toString(),
		endTime: endTime.value.toString(),
		postImg: imgList.value[0].url,
		ballId: formData.ballId,
		initiatorId: store.state.userId,
		reserveId: 1,
	};
	delete data["undefined"];

	if (await addPost(data)) {
		router.back();
		Toast.success("发帖成功");
	} else {
		Toast.fail("发帖失败");
	}
};
</script>
<style scoped>
.ap-container {
	padding-top: 40px;
}
.van-form {
	overflow-y: scroll;
	height: 100%;
}

.van-cell {
	height: 60px;
}
</style>
