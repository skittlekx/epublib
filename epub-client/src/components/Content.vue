<template>
  <el-container class="container">
    <el-header  style="height: 10%;">
      <el-row align="middle" type="flex" justify="end" style="height: 100%;">
        <el-button-group>
          <el-button type="primary" icon="el-icon-search" @click="search">搜索</el-button>
          <el-button type="primary" icon="el-icon-upload" @click="centerDialogVisible = true">上传</el-button>
        </el-button-group>
      </el-row>
    </el-header>
    <el-container style="height: 90%;">
      <div style="width: 20%; height: 100%;">
        <el-aside style="width: 100%;">
          <comAside :chapterList=chapterList></comAside>
        </el-aside>
      </div>
      <div style="width: 80%; height: 100%;">
        <el-main>
          <comMain :curChapter=curChapter></comMain>
        </el-main>
      </div>
    </el-container>
    <Upload :visible.sync="centerDialogVisible"></Upload>
  </el-container>
</template>

<script>

import comAside from './Aside'
import comMain from './Main'
import Upload from './Upload'

export default {
  data () {
    return {
      curChapter: 0,
      chapterList: [
        {
          'id': 0,
          'name': '正文卷',
          'level': 0,
          'child': [
            {
              'id': 1,
              'name': '描述',
              'level': 1,
              'child': null
            }
          ]
        }],
      // chapterList: [{'id': 0, 'name': '正文卷', 'level': 0, 'child': [{ 'id': 1, 'name': '描述', 'level': 1, 'child': null }]}],
      // chapterList: [{'id': '第一卷', 'chapters': [{'id': '第一章'}]}],
      centerDialogVisible: false
    }
  },
  methods: {
    search () {
      this.$router.replace({
        path: '/'
      })
    }
  },
  components: {
    comAside,
    comMain,
    Upload
  },
  mounted: function () {
    // if (this.$route.params.mlist === 'undefined') {
    //   this.chapterList = this.$route.params.mlist
    // }
    console.log('in content')
    this.chapterList = this.$route.params.mlist
    console.log(this.chapterList)
    console.log(this.$route.params.mlist)
  }
}

</script>

<style>
  .container{
    width: 100%;
    height: 100%;
  }
  .el-aside{
    width: 100%;
    height: 100%;
  }
  .el-main{
    padding: 0px;
    margin-left: 10px;
    margin-bottom: 10px;
    height: 100%;
  }
</style>
