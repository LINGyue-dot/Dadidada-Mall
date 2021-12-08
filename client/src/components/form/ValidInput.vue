<template>
  <input
      class="form-control"
      :class="{ 'is-invalid': inputRef.error }"
      id="validationServer05"
      aria-describedby="validationServer05Feedback"
      v-model="inputRef.val"
      @blur="validInput"
      @change="valueChange"
      v-bind="$attrs"
  />
  <div
      v-if="inputRef.error"
      id="validationServer05Feedback"
      class="invalid-feedback"
  >
    {{ inputRef.message }}
  </div>
</template>
<script lang="ts">
export default {
  inheritAttrs: false,
};
</script>
<script lang="ts" setup>
import {mitter} from "./ValidForm.vue";
import {PropType, reactive, onMounted, defineEmits, defineProps} from "vue";

interface InputRuleProp {
  type: "required" | "email";
  message: string;
}

export  type ValidRuleProp = InputRuleProp[];

const props = defineProps({
  rules: Object as PropType<ValidRuleProp>,
  modelValue: String, // 双向绑定
});

const emits = defineEmits(["update:modelValue"]);

const inputRef = reactive({
  val: props.modelValue,
  error: false,
  message: "",
});

const valueChange = (e: Event) => {
  const target = (e.target as HTMLInputElement).value;
  inputRef.val = target;
  emits("update:modelValue", target);
};

// 验证函数
const validInput = () => {
  if (props.rules) {
    const allPassed = props.rules.every(rule => {
      let passed = true;
      inputRef.message = rule.message;
      switch (rule.type) {
        case "required":
          passed = !!inputRef.val ? inputRef.val?.trim() !== "" : false;
          break;
        case "email":
          passed = !!inputRef.val?.includes("a");
        default:
          break;
      }
      return passed;
    });
    inputRef.error = !allPassed;
    return allPassed;
  }
  return true;
};

//  组件创建时候将验证函数传递给父组件
onMounted(() => {
  mitter.emit("form-item-created", validInput);
});
</script>
<style scoped></style>
