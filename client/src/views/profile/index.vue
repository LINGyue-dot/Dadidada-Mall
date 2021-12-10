<template>
	<div class="profile-container">
		<div class="top-set iconfont profile-paddding">
			<span class="set-icon"> &#xe892;</span>
		</div>
		<div class="info profile-paddding">
			<UserAvatar
				:url="store.state.userInfo?.userAvatar"
				:type="AvatarType.LARGE"
			/>
			<h3 class="info-name">{{ store.state.userInfo?.userName }}</h3>
		</div>
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
			<div class="flex-3-item list-item"></div>
			<div class="flex-3-item list-item"></div>
		</div>
	</div>
</template>
<script lang="ts" setup>
import UserAvatar, { AvatarType } from "@/components/avatar/UserAvatar.vue";
import { StateProp } from "@/store";
import { useStore } from "vuex";
import IconTitle from "@/components/icon-title/index.vue";

const store = useStore<StateProp>();
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
	flex-direction: row;
	/* align-items: center; */
}

.info-name {
	padding-left: 20px;
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
