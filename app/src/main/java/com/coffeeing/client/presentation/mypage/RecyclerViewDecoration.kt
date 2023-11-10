package com.coffeeing.client.presentation.mypage

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration


class RecyclerViewDecoration( // 간격 값
    private val spacing: Int
) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        // 아이템 간의 간격을 설정
        outRect.right = spacing // 오른쪽 간격
        //outRect.left = spacing; // 왼쪽 간격 (필요에 따라 사용)

        // 첫 번째 아이템에 왼쪽 간격을 주고 싶다면 아래 코드를 사용할 수 있습니다.
        //if (parent.getChildAdapterPosition(view) == 0) {
        //    outRect.left = spacing;
        //}
    }
}