<template>
	<div class="jp-container iconfont" @click="join">&#xe676;</div>
</template>
<script lang="ts" setup>
import { useRoute, useRouter } from "vue-router";

const route = useRoute();
const router = useRouter();
const join = () => {
	router.push("/join-post/" + route.params.id);
};
</script>
<style scoped>
.jp-container {
	position: fixed;
	bottom: 100px;
	right: 10px;
	border-radius: 50%;
	width: 50px;
	height: 50px;
	line-height: 50px;
	font-size: 30px;
	text-align: center;
	display: inline-block;
	background-color: #eee;
	z-index: 10;
}
</style>
