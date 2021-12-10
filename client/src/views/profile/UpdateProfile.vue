<template>
	<div class="up-container" :class="{ 'show-top': !isInit }">
		<div v-if="isInit" class="init profile-paddding">
			<h2 class="init-title">更新你的个人资料</h2>
		</div>
		<div v-else class="up-top">
			<TopBar to="/profile" title="更新资料" />
		</div>
		<div class="form">
			<van-form @submit="updateProfile">
				<van-field
					v-model="info.userName"
					name="userName"
					label="用户名"
					placeholder="用户名"
					:rules="[{ required: true, message: '请填写用户名' }]"
				/>
				<van-field
					name="userIdentity"
					label="性别"
					:rules="[{ required: true, message: '请填写身份' }]"
				>
					<template #input>
						<van-radio-group v-model="info.userIdentity" direction="horizontal">
							<van-radio name="teacher">教师</van-radio>
							<van-radio name="student">学生</van-radio>
							<van-radio name="other">其他</van-radio>
						</van-radio-group>
					</template>
				</van-field>
				<van-field name="userSex" label="身份">
					<template #input>
						<van-radio-group
							v-model="info.userSex"
							direction="horizontal"
							:rules="[{ required: true, message: '请填写性别' }]"
						>
							<van-radio name="male">男</van-radio>
							<van-radio name="female">女</van-radio>
						</van-radio-group>
					</template>
				</van-field>
				<van-field
					v-model="info.userHeight"
					name="userHeight"
					label="身高"
					placeholder="身高"
					type="number"
				/>
				<van-field
					v-model="info.userWeight"
					name="userWeight"
					type="number"
					label="体重"
					placeholder="体重"
				/>
				<van-field
					v-model="info.userAge"
					name="userAge"
					label="年龄"
					type="number"
					placeholder="年龄"
				/>
				<van-field
					v-model="info.userSpecialty"
					name="userSpecialty"
					label="特长"
					placeholder="特长"
				/>
				<van-field
					v-model="info.userIntroduction"
					name="userIntroduction"
					label="介绍"
					placeholder="介绍"
				/>
				<div style="margin: 16px">
					<van-button round block type="info" native-type="submit"
						>更新</van-button
					>
				</div>
			</van-form>
		</div>
	</div>
</template>
<script lang="ts" setup>
import { computed, reactive, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import TopBar from "@/components/top-bar/index.vue";
import { UserInfoProp } from "@/types/types";
import { useStore } from "vuex";
import { StateProp } from "@/store";
import { postUpdateProfile } from "@/htpp/api";
import { Toast } from "vant";

const route = useRoute();
const router = useRouter();
const isInit = computed(() => !!!route.params);
const store = useStore<StateProp>();

const info = reactive<Partial<UserInfoProp>>({
	userId: store.state.userInfo?.userId,
	userName: store.state.userInfo?.userName,
	userAvatar: store.state.userInfo?.userAvatar,
	userSex: store.state.userInfo?.userSex,
	userHeight: store.state.userInfo?.userHeight,
	userWeight: store.state.userInfo?.userWeight,
	userAge: store.state.userInfo?.userAge,
	userSpecialty: store.state.userInfo?.userSpecialty,
	userIntroduction: store.state.userInfo?.userIntroduction,
	userIdentity: store.state.userInfo?.userIdentity,
});

onMounted(() => {
	console.log(info);
});

const updateProfile = async (values: any) => {
	const userInfo = {
		...values,
		userAvatar: store.state.userInfo?.userAvatar,
		userId: store.state.userId,
	};
	console.log(userInfo);
	const res = await postUpdateProfile(userInfo);
	if (!res) {
		Toast.fail("更新失败");
	} else {
		Toast.success("更新成功");
		store.dispatch("updateProfile", userInfo);
	}
	router.push("/home");
};
</script>
<style scoped>
.up-container {
	overflow-y: scroll;
}
.show-top {
	padding-top: 40px;
}
.van-cell {
	height: 60px;
}
.init {
	height: 50px;
}
.init-tile {
}
.up-top {
}
</style>
