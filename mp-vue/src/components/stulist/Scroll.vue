<template>
  <div class="infinite-list-wrapper" style="overflow:auto">
    <ul
      class="list"
      v-infinite-scroll="load"
      infinite-scroll-disabled="disabled">
      <div v-for="i in count" class="list-item">
        <el-row>
          <el-col :span="4"><Headimg/></el-col>
          <el-col :span="10"><Stutags/></el-col>
        </el-row>
      </div>
    </ul>
    <p v-if="loading">加载中...</p>
    <p v-if="noMore">没有更多了</p>
  </div>
</template>

<script>
  import Headimg from '@/components/stulist/Headimg'
  import Stutags from '@/components/stulist/Stutags'
  export default {
    name:'Scroll',
    data () {
      return {
        count: 30,
        loading: false
      }
    },
    computed: {
      noMore () {
        return this.count >= 100
      },
      disabled () {
        return this.loading || this.noMore
      }
    },
    components:{
      Headimg,
      Stutags,
    },
    methods: {
      load () {
        this.loading = true
        setTimeout(() => {
          this.count += 2
          this.loading = false
        }, 2000)
      }
    }
  }
</script>