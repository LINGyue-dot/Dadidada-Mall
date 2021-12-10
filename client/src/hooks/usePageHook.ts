/*
 * @Author: qianlong github:https://github.com/LINGyue-dot
 * @Date: 2021-12-10 00:40:20
 * @LastEditors: qianlong github:https://github.com/LINGyue-dot
 * @LastEditTime: 2021-12-10 13:15:59
 * @Description:
 */
import { ref } from "vue";

export const usePage = () => {
  const pageSize = ref(10);
  const pageNum = ref(1);
  const nextPage = () => {
    pageNum.value++;
  };
  const initPage = () => {
    pageSize.value = 1;
    pageNum.value = 10;
  };
  return {
    pageSize,
    pageNum,
    nextPage,
    initPage,
  };
};
