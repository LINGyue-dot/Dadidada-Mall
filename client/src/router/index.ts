/*
 * @Author: qianlong github:https://github.com/LINGyue-dot
 * @Date: 2021-12-03 15:19:58
 * @LastEditors: qianlong github:https://github.com/LINGyue-dot
 * @LastEditTime: 2021-12-16 19:46:00
 * @Description:
 */
import store from "@/store";
import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/login",
    component: () => import("@/views/login/index.vue"),
  },
  {
    path: "/",
    component: () => import("@/layout/index.vue"),
    redirect: "/home",
    children: [
      {
        path: "home",
        component: () => import("@/views/home/index.vue"),
      },
      {
        path: "profile",
        component: () => import("@/views/profile/index.vue"),
      },
    ],
  },
  {
    path: "/add-post",
    component: () => import("@/views/add-post/index.vue"),
  },
  {
    path: "/demo",
    component: () => import("@/views/demo/index.vue"),
  },
  {
    path: "/update-profile",
    component: () => import("@/views/profile/UpdateProfile.vue"),
  },
  {
    path: "/post/:id",
    component: () => import("@/views/post/index.vue"),
  },
  {
    path: "/join-post/:id",
    component: () => import("@/views/join-post/index.vue"),
  },
  {
    path: "/applicant",
    component: () => import("@/views/applicant/index.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

router.beforeEach((to, from, next) => {
  if (store.state.login || to.path == "/login") {
    next();
  } else {
    next("/login");
  }
});

export default router;
