<template>
	<div class="bottom-bar">
		<router-link
			class="home flex-1 iconfont"
			to="/home"
			:class="{ active: $route.path == '/home' }"
			>&#xe6af;</router-link
		>
		<router-link class="add flex-1 iconfont" to="/add-post"
			>&#xe660;</router-link
		>
		<router-link
			class="profile flex-1 iconfont"
			to="/profile"
			:class="{ active: $route.path == '/profile' }"
			>&#xe655;</router-link
		>
	</div>
</template>
<script lang="ts" setup></script>
<style scoped>
.bottom-bar {
	position: fixed;
	width: 100%;
	height: 60px;
	bottom: 0;
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
	background-color: #fafafa;
}

.flex-1 {
	flex: 1;
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 30px;
	color: #000;
}
.home {
}
.add {
	font-size: 35px;
}
.profile {
	font-size: 35px;
}

.active {
	color: var(--color);
}
</style>
