<template>
  <div style="height: 100%;">
    <div style="height: 10%;">
      <el-menu
        class="el-menu-aside-title"
        text-color="#000"
        active-text-color="#ffd04b"
        background-color: aliceblue
        >
        <el-menu-item>
          <i class="el-icon-menu"></i>
          章节标题
        </el-menu-item>
      </el-menu>
    </div>
    <div class="menu" style="height: 90%;">
      <el-menu
        class="el-menu-aside-contents"
        text-color="#000"
        :unique-opened="true"
        active-text-color="#ffd04b"
        @click="onClick(item, key, keyPath)">

        <el-submenu
          :index="item.id + ''"
          v-for="item in chapterList"
          :key="item.id"
        >
          <template slot="title">
            <span>{{ item.name }}</span>
          </template>
          <el-menu-item
            :index="item.id + '-' + subItem.id"
            v-for="subItem in item.child"
            :key="subItem.id"
          >
            <span slot="title">{{ subItem.name }}</span>
          </el-menu-item>
        </el-submenu>
      </el-menu>
    </div>
  </div>
</template>

<script>
export default{
  // data () {
  //   return {
  //     chapterList: []
  //     // menuList: [{'id': '第一卷', 'chapters': [{'id': '第一章'}]}]
  //   }
  // },
  methods: {
    onClick (item, key, keyPath) {
      console.log(item)
      console.log(key)
      console.log(keyPath)
    }
  },
  props: {
    chapterList: []
  }
}
</script>

<style>
  .el-menu-aside-title{
    background-color: aliceblue;
    height: 100%;
  }
  .el-menu-aside-contents{
    background-color: aliceblue;
    height: 100%;
    overflow: auto;
  }
</style>
