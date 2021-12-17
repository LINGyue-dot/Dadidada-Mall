<template>
	<div class="profile-container">
		<div class="top-set iconfont profile-paddding">
			<span class="set-icon"> &#xe892;</span>
		</div>
		<van-uploader class="info profile-paddding" :after-read="afterRead">
			<!-- <UserAvatar
				:url="store.state.userInfo?.userAvatar"
				:type="AvatarType.LARGE"
			/> -->
			<van-image
				style="display: inline-block"
				round
				width="10rem"
				fit="cover"
				height="10rem"
				:src="store.state.userInfo?.userAvatar"
			/>
			<h3 class="info-name">{{ store.state.userInfo?.userName }}</h3>
		</van-uploader>
		<div class="list profile-paddding flex-3">
			<div
				class="flex-3-item list-item"
				@click="$router.push('/update-profile')"
			>
				<IconTitle :icon-content="'&#xe62c;'" title="更新资料" />
			</div>
			<div class="flex-3-item list-item" @click="store.dispatch('logout')">
				<IconTitle :icon-content="'&#xe66b;'" title="退出登录" />
			</div>
			<div class="flex-3-item list-item">
				<IconTitle
					:icon-content="'&#xe6f4;'"
					title="申请列表"
					@click="$router.push('/applicant')"
				/>
			</div>
			<!-- <div class="flex-3-item list-item"></div> -->
		</div>
	</div>
</template>
<script lang="ts" setup>
import UserAvatar, { AvatarType } from "@/components/avatar/UserAvatar.vue";
import { StateProp } from "@/store";
import { useStore } from "vuex";
import IconTitle from "@/components/icon-title/index.vue";
import { UploadImg } from "@/htpp/upload";
import { loginStorage } from "@/util/storgae";
import { updateAvatar } from "@/htpp/api";

const store = useStore<StateProp>();
const afterRead = async (file: any) => {
	// 此时可以自行将文件上传至服务器
	UploadImg(file.file).then(res => {
		console.log(res);
		store.state.userInfo = {
			...store.state.userInfo,
			userAvatar: res.data.url,
		};
		loginStorage(store.state.userInfo);
		updateAvatar(res.data.url);
	});
};
</script>
<style scoped>
.profile-container {
	display: flex;
	flex-direction: column;
	width: 100%;
	height: 100%;
}
.top-set {
	flex: 1;
	display: flex;
	flex-direction: row-reverse;
}

.info {
	flex: 2;
	display: flex;
	flex-direction: column;
	align-items: center;
	/* align-items: center; */
}

.info-name {
	margin-top: 20px;
	/* padding-left: 20px; */
	text-align: center;
}

.list {
	flex: 9;
}
.list-item {
	height: 24vw;
}
.set-icon {
	font-size: 25px;
}
</style>
