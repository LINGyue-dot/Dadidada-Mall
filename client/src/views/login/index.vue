<template>
	<div class="login-container">
		<h2 class="login-title iconfont" @click="switchRegister">
			{{ isLogin ? "登录" : "注册" }}
		</h2>
		<div class="form-container">
			<div class="form">
				<ValidForm @form-submit="formSubmit">
					<div>
						<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">用户名</label>
							<ValidInput :rules="nameRules" v-model="username" type="text" />
						</div>
						<div class="mb-3">
							<label for="exampleInputPassword1" class="form-label"
								>Password</label
							>
							<ValidInput
								:rules="passwordRules"
								v-model="password"
								type="password"
							/>
						</div>
					</div>
					<template #submit
						><button type="submit" class="btn btn-primary">
							{{ isLogin ? "登录" : "注册" }}
						</button></template
					>
				</ValidForm>
			</div>
		</div>
	</div>
</template>
<script lang="ts" setup>
import { ref } from "vue";
import ValidForm from "@/components/form/ValidForm.vue";
import ValidInput, { ValidRuleProp } from "@/components/form/ValidInput.vue";
import { useStore } from "vuex";
import { StateProp } from "@/store";

const nameRules: ValidRuleProp = [
	{
		type: "required",
		message: "必填项",
	},
];

const passwordRules: ValidRuleProp = [
	{
		type: "required",
		message: "必填项",
	},
];
const store = useStore<StateProp>();
const isLogin = ref(true);

const username = ref();
const password = ref();

const switchRegister = () => {
	isLogin.value = !isLogin.value;
};

const formSubmit = (val: boolean) => {
	if (!val) {
		return;
	}
	if (isLogin.value) {
		login();
	} else {
		register();
	}
};

const login = () => {
	store.dispatch("login", {
		userName: username.value,
		password: password.value,
	});
};

const register = async () => {
	store.dispatch("register", {
		userName: username.value,
		userPassword: password.value,
	});
};
</script>
<style scoped>
.login-container {
	width: 100vw;
	height: 100vh;
	overflow: hidden;
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.login-title {
	flex: 2;
	font-size: 40px;
	text-align: left;
	padding-left: 25px;
	line-height: 70px;
	position: relative;
}
.login-title::after {
	content: "\e621";
	position: absolute;
	right: 20px;
}
.form-container {
	flex: 5;
	display: flex;
	flex-direction: row;
	justify-content: center;
}
.form {
	width: 70%;
	height: 300px;
}
</style>
