<template>
  <quill-editor class="editor" v-model="content" ref="myQuillEditor" :options="editorOption"
    @blur="onEditorBlur($event)" @focus="onEditorFocus($event)" @change="onEditorChange($event)"
    aria-placeholder="text">
  </quill-editor>
</template>
<script>
export default {
  name: 'Editor',
  data () {
    return {
      content: '',
      editorOption: {}
    }
  },
  methods: {
    onEditorBlur () {},
    onEditorFocus () {
    },
    onEditorChange () {
    }
  }
}

</script>

<style>
  .editor{
    background-color: aliceblue;
    height: 100%;
  }
</style>
