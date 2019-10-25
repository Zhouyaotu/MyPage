<template>
  <div>
    <span class="demonstration">兴趣标签</span>
    <el-select v-model="value" multiple filterable class="spsize" placeholder="请选择">
      <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value"
        style="height:100%"
        >
      </el-option>
    </el-select>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        options: [{
          value: '选项1',
          label: '黄金糕'
        }, {
          value: '选项2',
          label: '双皮奶'
        }, {
          value: '选项3',
          label: '蚵仔煎'
        }, {
          value: '选项4',
          label: '龙须面'
        }, {
          value: '选项5',
          label: '北京烤鸭'
        }, {
          value: '选项6',
          label: '黄金糕'
        }, {
          value: '选项7',
          label: '双皮奶'
        }, {
          value: '选项8',
          label: '蚵仔煎'
        }, {
          value: '选项9',
          label: '龙须面'
        }, {
          value: '选项10',
          label: '北京烤鸭'
        }],
        value: ''
      }
    }
  }
</script>

<style>
  .spsize{
    width: 100%;
  }
</style>