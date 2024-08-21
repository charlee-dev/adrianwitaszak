import { Card } from '@/components/Card'
import { Section } from '@/components/Section'
import { SimpleLayout } from '@/components/SimpleLayout'

function ToolsSection({
  children,
  ...props
}: React.ComponentPropsWithoutRef<typeof Section>) {
  return (
    <Section {...props}>
      <ul role="list" className="space-y-16">
        {children}
      </ul>
    </Section>
  )
}

function Tool({
  title,
  href,
  children,
}: {
  title: string
  href?: string
  children: React.ReactNode
}) {
  return (
    <Card as="li">
      <Card.Title as="h3" href={href}>
        {title}
      </Card.Title>
      <Card.Description>{children}</Card.Description>
    </Card>
  )
}

export const metadata = {
  title: 'Uses',
  description: 'Software I use, gadgets I love, and other things I recommend.',
}

export default function Uses() {
  return (
    <SimpleLayout
      title="Software I use, gadgets I love, and other things I recommend."
      intro="I get asked a lot about the things I use to build software, stay productive, or buy to fool myself into thinking I’m being productive when I’m really just procrastinating. Here’s a big list of all of my favorite stuff."
    >
      <div className="space-y-20">
        <ToolsSection title="Workstation">
          <Tool title="16” MacBook Pro, M3 Max, 64GB RAM (2024)">
            I was using an Intel-based 16” MacBook Pro prior to this and the
            difference is night and day. I’ve never heard the fans turn on a
            single time, even under the incredibly heavy loads I put it through
            with our various launch simulations.
          </Tool>
          <Tool title="Apple Pro Display XDR (Standard Glass)">
            The only display on the market if you want something HiDPI and
            bigger than 27”. When you’re working at planetary scale, every pixel
            you can get counts.
          </Tool>
          <Tool title="Apple Magic Keyboard">
            I’ve tried to switch to mechanical keyboards but I always end up
            back here. The key travel is just too good.
          </Tool>
          <Tool title="Apple Magic Trackpad">
            Something about all the gestures makes me feel like a wizard with
            special powers. I really like feeling like a wizard with special
            powers.
          </Tool>
          <Tool title="Leap – Ergonomic office chair">
            If I’m going to slouch in the worst ergonomic position imaginable
            all day, I might as well do it in an expensive chair.
          </Tool>
        </ToolsSection>
        <ToolsSection title="Development tools">
          <Tool title="VSCode">
            I’ve tried to switch to other editors but I always end up back here.
            The ecosystem is just too good.
          </Tool>
          <Tool title="IntelliJ">
            I use IntelliJ for all of my Java and Kotlin work. It’s the best
            IDE, hands down.
          </Tool>
          <Tool title="Android Studio">
            I don’t like it but I have to use it. It’s the best tool for Android
            development.
          </Tool>
          <Tool title="Xcode">
            I don’t like it but I have to use it. It’s the best tool for iOS
            development.
          </Tool>
        </ToolsSection>
        <ToolsSection title="Design">
          <Tool title="Figma">
            We started using Figma as just a design tool but now it’s become our
            virtual whiteboard for the entire company. Never would have expected
            the collaboration features to be the real hook.
          </Tool>
        </ToolsSection>
        <ToolsSection title="Productivity">
          <Tool title="Raycast">
            I use Raycast for all of my quick actions and app launching. It’s
            like Alfred but with a lot more features built in.
          </Tool>
          <Tool title="Warp">
            Warp is a modern terminal with AI built in. It enhances productivity
            with features like command predictions, smart search, and
            collaborative sessions.
          </Tool>
          <Tool title="In Your Face">
            I use In Your Face to remind myself to take breaks. It’s easy to get
            lost in work and forget to take care of yourself.
          </Tool>
        </ToolsSection>
      </div>
    </SimpleLayout>
  )
}
