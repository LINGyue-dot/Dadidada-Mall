<template>
	<div class="bottom-bar">
		<div class="home"></div>
		<div class="add"></div>
		<div class="profile"></div>
	</div>
</template>
<script lang="ts" setup></script>
<style scoped>
.bottom-bar {
	position: fixed;
	width: 100%;
	height: 50px;
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
}

.home {
	flex: 1;
}
.add {
	flex: 1;
}
.profile {
	flex: 1;
}
</style>
