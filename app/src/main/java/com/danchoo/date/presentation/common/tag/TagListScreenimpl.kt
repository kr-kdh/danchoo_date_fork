package com.danchoo.date.presentation.common.tag

import android.content.res.Configuration
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.danchoo.components.event.OnViewEvent
import com.danchoo.components.theme.MyApplicationTheme
import com.danchoo.components.ui.appbar.BackTopAppBar
import com.danchoo.components.ui.button.OutlinedTextButton
import com.danchoo.components.ui.button.TagItemButton
import com.danchoo.date.R
import com.danchoo.date.presentation.common.tag.TagListContract.TagListViewState
import com.danchoo.tags.domain.model.TagGroupModel
import com.danchoo.tags.domain.model.TagModel
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun TagListScreenImpl(
    modifier: Modifier = Modifier,
    viewState: TagListViewState,
    onViewEvent: OnViewEvent = {},
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            BackTopAppBar(
                title = {

                },
                onClickBack = {}
            )
        }
    ) {
        when {
            viewState.keyword.isNotEmpty() -> {
                TagSearchResult(Modifier.padding(it))
            }
            viewState.tagGroupList.isEmpty() -> {
                TagListEmpty(
                    modifier = Modifier
                        .padding(it)
                        .fillMaxSize(),
                    onClickAdd = {

                    }
                )
            }
            else -> {
                TagListContents(
                    modifier = Modifier.padding(it),
                    selectedList = viewState.selectedList,
                    recentList = viewState.recentList,
                    tagGroupList = viewState.tagGroupList,
                    tagQuickSearchResult = viewState.quickSearchResult,
                    onDeleteRecent = { tagModel ->

                    },
                    onDeleteSelected = { tagModel ->

                    },
                    onSelect = { tagModel ->

                    },
                    onSelectTagGroup = { tagGroupModel ->

                    },
                    onCloseQuickSearchResult = {

                    }
                )
            }
        }
    }
}

@Composable
private fun TagListEmpty(
    modifier: Modifier = Modifier,
    onClickAdd: () -> Unit = {}
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Spacer(modifier = Modifier.weight(0.4f))

        Text(
            text = stringResource(id = R.string.tag_list_empty_message),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.size(MyApplicationTheme.spacing.baseLineSpacing))

        OutlinedTextButton(
            modifier = Modifier.wrapContentSize(),
            text = stringResource(id = R.string.tag_list_empty_button_message),
            onClick = onClickAdd
        )

        Spacer(modifier = Modifier.weight(0.6f))
    }
}

@Composable
private fun TagListContents(
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),
    selectedList: List<TagModel> = emptyList(),
    recentList: List<TagModel> = emptyList(),
    tagGroupList: List<TagGroupModel> = emptyList(),
    tagQuickSearchResult: List<TagModel> = emptyList(),
    onDeleteSelected: (TagModel) -> Unit,
    onSelect: (TagModel) -> Unit,
    onDeleteRecent: (TagModel) -> Unit,
    onSelectTagGroup: (TagGroupModel) -> Unit,
    onCloseQuickSearchResult: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(MyApplicationTheme.spacing.baseLineSpacing)
    ) {
        if (selectedList.isNotEmpty()) {
            TagListFlowRow(
                tagList = selectedList,
                onClickDelete = { tagModel ->
                    onDeleteSelected(tagModel)
                }
            )
        }

        if (recentList.isNotEmpty()) {
            TagListFlowRow(
                tagList = selectedList,
                onClick = onSelect,
                onClickDelete = { tagModel ->
                    onDeleteRecent(tagModel)
                }
            )
        }

        if (tagGroupList.isNotEmpty()) {
            TagQuickSearch(
                modifier = Modifier,
                tagGroupList = tagGroupList,
                tagQuickSearchResult = tagQuickSearchResult,
                onClickTagGroup = onSelectTagGroup,
                onClickTag = onSelect,
                onClickClose = onCloseQuickSearchResult
            )
        }
    }
}


@Composable
private fun TagListFlowRow(
    modifier: Modifier = Modifier,
    tagList: List<TagModel> = emptyList(),
    onClick: ((TagModel) -> Unit)? = null,
    onClickDelete: ((TagModel) -> Unit)? = null
) {
    FlowRow(
        modifier = modifier.fillMaxSize()
    ) {
        tagList.forEach { tagModel ->
            TagItemButton(
                tagName = tagModel.tag,
                onClick = onClick?.let {
                    { onClick(tagModel) }
                },
                onClickDelete = onClickDelete?.let {
                    { onClickDelete(tagModel) }
                }
            )
        }
    }
}

@Composable
private fun TagQuickSearch(
    modifier: Modifier = Modifier,
    tagGroupList: List<TagGroupModel> = emptyList(),
    tagQuickSearchResult: List<TagModel> = emptyList(),
    onClickTagGroup: (TagGroupModel) -> Unit = {},
    onClickTag: (TagModel) -> Unit = {},
    onClickClose: () -> Unit
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .clip(MaterialTheme.shapes.small)
    ) {
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            tagGroupList.forEach { tagGroupModel ->
                TagItemButton(
                    tagName = tagGroupModel.title,
                    onClick = {
                        onClickTagGroup(tagGroupModel)
                    }
                )
            }
        }

        TagListFlowRow(
            tagList = tagQuickSearchResult,
            onClick = onClickTag
        )
    }
}

@Composable
private fun TagSearchResult(
    modifier: Modifier = Modifier
) {

}


@Preview("light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TagListScreenPreview() {
    MyApplicationTheme {
        TagListScreenImpl(viewState = TagListViewState())
    }
}
