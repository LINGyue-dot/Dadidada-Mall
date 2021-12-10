<template>
	<van-popup
		v-model:show="timerShow"
		position="bottom"
		round
		:style="{
			height: '40%',
		}"
	>
		<van-datetime-picker
			v-model="currentDate"
			type="datehour"
			title="选择年月日小时"
			:min-date="minDate"
			:max-date="maxDate"
			@confirm="confirm"
			@cancel="cancel"
		></van-datetime-picker>
	</van-popup>
</template>
<script lang="ts" setup>
import { ref, watch } from "vue";
const timerShow = ref(false);
const showTimerPicker = () => {
	timerShow.value = true;
};
defineExpose({
	showTimerPicker,
});
const emit = defineEmits(["emitTimer"]);

const currentDate = ref(new Date());
const minDate = new Date(2021, 0, 1);
const maxDate = new Date(2022, 11, 31);

const confirm = () => {
	timerShow.value = false;
};
const cancel = () => {
	timerShow.value = false;
};

watch(
	() => timerShow.value,
	(newVal, oldVal) => {
		if (newVal === false && oldVal) {
			emit("emitTimer", currentDate.value);
		}
	}
);
</script>
<style scoped></style>
