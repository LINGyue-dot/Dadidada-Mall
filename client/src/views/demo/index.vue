<template>
	<div class="content">
		<form>
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email address</label>
				<ValidInput :rules="emialRules" />
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input
					type="password"
					class="form-control"
					id="exampleInputPassword1"
				/>
			</div>
			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1" />
				<label class="form-check-label" for="exampleCheck1">Check me out</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</template>
<script lang="ts" setup>
import { ValidRuleProp } from "@/components/form/ValidInput.vue";
import ValidInput from "../../components/form/ValidInput.vue";

const emialRules: ValidRuleProp = [
	{
		type: "required",
		message: "该字段必填",
	},
	{
		type: "email",
		message: "不是个有效的邮箱地址",
	},
];
</script>
<style scoped>
.content {
	width: 100vw;
	height: 100vh;
	box-sizing: border-box;
	padding: 10vw;
}
</style>
