<template>
  <form class="validate-form-container">
    <slot name="default"></slot>
    <div class="submit-area" @click.prevent="submitForm">
      <slot name="submit">
        <button type="submit" class="btn btn-primary">提交</button>
      </slot>
    </div>
  </form>
</template>

<script lang="ts">
import mitt from "mitt";

export const mitter = mitt();
</script>
<script lang="ts" setup>
import {defineEmits, defineExpose, onBeforeMount} from "vue";

type ValidFn = () => boolean;
type ValidFns = ValidFn[];
const emits = defineEmits(["form-submit"]);
let validFns: ValidFns = [];
// 点击触发验证事件
// 验证函数
const submitForm = () => {
  // 触发每个组件的验证函数，同时若存在 false 则整体就返回 false
  const passed = validFns.map(fn => fn()).every(r => r);
  emits("form-submit", passed);
};

// onmounted 时候接收子组件传来的验证函数
onBeforeMount(() => {
  mitter.on("form-item-created", cb => {
    validFns.push(cb as ValidFn);
  });
});

defineExpose({submitForm});
</script>
<style scoped></style>
