<template>
  <div style="height:100%;overflow-y: auto">
    <quill-editor class="editor" v-model="content"
      @change="onEditorChange($event)">
    </quill-editor>
  </div>
</template>

<script>
export default {
  props: {
    curChapter: 0
  },
  data () {
    return {
      activeName: 'first',
      textareaHtml: '',
      content: '',
      editorOption: {}
    }
  },
  methods: {
    handleClick (tab, event) {
      console.log(tab, event)
    },
    onEditorChange ({ quill, html, text }) {
      console.log('editor change!', quill, html, text)
      console.log(this.content)
    },
    getData (chapter) {
      console.log(chapter)

      let url = '/chapter' + '/' + chapter
      this.$axios
        .get(url)
        .then(Resp => {
          console.log(Resp)
          this.content = Resp.data.data
        })
        .catch(failReso => {
        })
    }
  },
  mounted: function () {
    console.log(this.curChapter)
    this.getData(this.curChapter)
  }
}
</script>

<style>
  .editor{
    background-color:aliceblue;
    color:black;
    flex: 1;
    height: 100%;
  }
  .ql-toolbar{
    height: 10%;
  }
  .ql-container{
    height: 90%;
  }
</style>
