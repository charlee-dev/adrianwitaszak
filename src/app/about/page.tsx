import { type Metadata } from 'next'
import Image from 'next/image'
import Link from 'next/link'
import clsx from 'clsx'
import { Container } from '@/components/Container'
import portraitImage from '@/images/portrait.jpg'
import { aboutMeData } from '@/lib/about-me-data'

function SocialLink({
  className,
  href,
  children,
  icon: Icon,
}: {
  className?: string
  href: string
  icon: React.ComponentType<{ className?: string }>
  children: React.ReactNode
}) {
  return (
    <li className={clsx(className, 'flex')}>
      <Link
        href={href}
        className="group flex text-sm font-medium text-zinc-800 transition hover:text-teal-500 dark:text-zinc-200 dark:hover:text-teal-500"
      >
        <Icon className="h-6 w-6 flex-none fill-zinc-500 transition group-hover:fill-teal-500" />
        <span className="ml-4">{children}</span>
      </Link>
    </li>
  )
}

function MailIcon(props: React.ComponentPropsWithoutRef<'svg'>) {
  return (
    <svg viewBox="0 0 24 24" aria-hidden="true" {...props}>
      <path
        fillRule="evenodd"
        d="M6 5a3 3 0 0 0-3 3v8a3 3 0 0 0 3 3h12a3 3 0 0 0 3-3V8a3 3 0 0 0-3-3H6Zm.245 2.187a.75.75 0 0 0-.99 1.126l6.25 5.5a.75.75 0 0 0 .99 0l6.25-5.5a.75.75 0 0 0-.99-1.126L12 12.251 6.245 7.187Z"
      />
    </svg>
  )
}

export const metadata: Metadata = {
  title: 'About ' + aboutMeData.name,
  description: aboutMeData.metaDescription,
}

export default function About() {
  return (
    <Container className="mt-16 sm:mt-32">
      <div className="grid grid-cols-1 gap-y-16 lg:grid-cols-2 lg:grid-rows-[auto_1fr] lg:gap-y-12">
        <div className="lg:pl-20">
          <div className="max-w-xs px-2.5 lg:max-w-none">
            <Image
              src={portraitImage}
              alt=""
              sizes="(min-width: 1024px) 32rem, 20rem"
              className="aspect-square rotate-3 rounded-2xl bg-zinc-100 object-cover dark:bg-zinc-800"
            />
          </div>
        </div>
        <div className="lg:order-first lg:row-span-2">
          <h1 className="text-4xl font-bold tracking-tight text-zinc-800 sm:text-5xl dark:text-zinc-100">
            I’m Adrian Witaszak from York, leading CharLEE X and creating
            cutting-edge software.
          </h1>
          <div className="mt-6 space-y-7 text-base text-zinc-600 dark:text-zinc-400">
            <p>
              My journey in technology began with a fascination for how software
              can transform ideas into reality. This passion led me to establish
              <strong> CharLEE X</strong>, a dynamic software agency
              specializing in eCommerce and bespoke software solutions tailored
              to meet the unique needs of businesses in today&apos;s digital
              landscape.
            </p>
            <p>
              With extensive experience in cross-platform development, I pride
              myself on delivering{' '}
              <strong>
                high-quality, scalable, and user-centric applications
              </strong>{' '}
              that drive growth and efficiency. At <strong>CharLEE X</strong>,
              my team and I are committed to leveraging the latest technologies
              to help our clients stay ahead in an ever-evolving market.
            </p>
            <p>
              When I&apos;m not immersed in code or strategizing the next big
              project, you can find me on the karting track, embracing the
              thrill and precision of racing. This love for speed and
              competition fuels my drive for <em>excellence</em> and{' '}
              <em>innovation</em> in the tech world.
            </p>
          </div>
        </div>
        <div className="lg:pl-20">
          <ul role="list">
            {aboutMeData.socialLinks.map(({ name, href, icon, aria }) => (
              <SocialLink
                href={href ?? ''}
                icon={icon}
                key={href}
                aria-label={aria}
              >
                Follow on {name}
              </SocialLink>
            ))}
            <SocialLink
              href="mailto:adrianwitaszak@gmail.com"
              icon={MailIcon}
              className="mt-8 border-t border-zinc-100 pt-8 dark:border-zinc-700/40"
            >
              Get in touch
            </SocialLink>
          </ul>
        </div>
      </div>
    </Container>
  )
}
