package com.adwi.site.components.sections

import androidx.compose.runtime.Composable
import com.adwi.site.components.composables.TextLink
import com.adwi.site.components.composables.AWLogo
import com.adwi.site.components.composables.EmSpacer
import com.adwi.site.components.composables.H2Subtitle
import com.adwi.site.components.composables.SocialLinkItem
import com.adwi.site.components.layouts.FullWidthLayout
import com.adwi.site.components.theme.Colors
import com.adwi.site.components.theme.contentColor
import com.adwi.site.components.utils.Strings
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.silk.components.icons.fa.FaCopyright
import com.varabyte.kobweb.silk.components.icons.fa.FaGithubAlt
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedinIn
import com.varabyte.kobweb.silk.components.icons.fa.FaMailBulk
import com.varabyte.kobweb.silk.components.icons.fa.FaTwitter
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px

@Composable
fun Footer() {
    FullWidthLayout(
        backgroundColor = Colors.primary
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .margin(topBottom = 7.em, leftRight = 2.em)
        ) {
            AWLogo(modifier = Modifier.color(Colors.white))
            EmSpacer(2.0)
            H2Subtitle(
                text = Strings.Footer.living,
                color = Colors.white,
                fontSize = 1.2.em,
                opacity = .7
            )
            H2Subtitle(
                text = Strings.Footer.oneDay,
                color = Colors.white,
                fontSize = 1.2.em,
                opacity = .7
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .margin(topBottom = 3.em, leftRight = 0.em)
            ) {
                val iconSize = 18.px
                SocialLinkItem(
                    href = Strings.Footer.twitterLink,
                    icon = { isHovered ->
                        FaTwitter(modifier = Modifier
                            .fontSize(iconSize)
                            .color(contentColor(!isHovered))
                        )
                    }
                )
                SocialLinkItem(
                    href = Strings.Footer.linkedInLink,
                    icon = { isHovered ->
                        FaLinkedinIn(
                            modifier = Modifier
                                .fontSize(iconSize)
                                .color(contentColor(!isHovered))
                        )
                    }
                )
                SocialLinkItem(
                    href = Strings.Footer.githubAWLink,
                    icon = { isHovered ->
                        FaGithubAlt(
                            modifier = Modifier
                                .fontSize(iconSize)
                                .color(contentColor(!isHovered))
                        )
                    }
                )
                SocialLinkItem(
                    href = Strings.Footer.mailLink,
                    icon = { isHovered ->
                        FaMailBulk(
                            modifier = Modifier
                                .fontSize(iconSize)
                                .color(contentColor(!isHovered))
                        )
                    }
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {
                H2Subtitle(
                    text = Strings.Footer.handcrafted,
                    color = Colors.white,
                    opacity = .7
                )
                FaCopyright(
                    modifier = Modifier
                        .color(Colors.white)
                        .margin(4.px)
                        .opacity(.7)
                )
                H2Subtitle(
                    text = Strings.Footer.adwi,
                    color = Colors.white,
                    opacity = .7
                )
            }
            EmSpacer()
            H2Subtitle(
                text = Strings.Footer.made,
                color = Colors.white,
                opacity = .7
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.margin(top = .25.em)
            ) {
                TextLink(
                    text = Strings.Footer.composeForWeb,
                    color = Colors.white,
                    href = Strings.Footer.composeForWebLink,
                )
                H2Subtitle(
                    text = Strings.Footer.and,
                    color = Colors.white,
                    opacity = .7
                )
                TextLink(
                    text = Strings.Footer.kobweb,
                    color = Colors.white,
                    href = Strings.Footer.kobwebLink,
                )
            }
        }
    }
}

